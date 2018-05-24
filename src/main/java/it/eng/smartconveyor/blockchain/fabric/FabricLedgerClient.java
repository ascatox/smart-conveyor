package it.eng.smartconveyor.blockchain.fabric;

import it.eng.smartconveyor.blockchain.base.LedgerClient;
import it.eng.smartconveyor.tool.JsonConverter;
import it.eng.smartconveyor.blockchain.fabric.config.ConfigManager;
import it.eng.smartconveyor.blockchain.fabric.config.Configuration;
import it.eng.smartconveyor.blockchain.fabric.config.Organization;
import it.eng.smartconveyor.blockchain.fabric.helper.Function;
import it.eng.smartconveyor.blockchain.fabric.helper.InvokeReturn;
import it.eng.smartconveyor.blockchain.fabric.helper.LedgerInteractionHelper;
import it.eng.smartconveyor.blockchain.fabric.helper.QueryReturn;
import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Bay;
import it.eng.smartconveyor.model.Item;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//@Component
final public class FabricLedgerClient implements LedgerClient {

    private final static Logger log = LogManager.getLogger(FabricLedgerClient.class);

    private LedgerInteractionHelper ledgerInteractionHelper;
    private ConfigManager configManager;
    private Validator validator;

    public FabricLedgerClient() throws ConveyorHubException {
        doLedgerClient();
    }


    private void doLedgerClient() throws ConveyorHubException {
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
            configManager = ConfigManager.getInstance();
            Configuration configuration = configManager.getConfiguration();
            if (null == configuration || null == configuration.getOrganizations() || configuration.getOrganizations().isEmpty()) {
                log.error("Configuration missing!!! Check you config file!!!");
                throw new ConveyorHubException("Configuration missing!!! Check you config file!!!");
            }
            List<Organization> organizations = configuration.getOrganizations();
            if (null == organizations || organizations.isEmpty())
                throw new ConveyorHubException("Organizations missing!!! Check you config file!!!");
            //for (Organization org : organizations) {
            //FIXME multiple Organizations
            ledgerInteractionHelper = new LedgerInteractionHelper(configManager, organizations.get(0));
            //}
        } catch (Exception e) {
            log.error(e);
            throw new ConveyorHubException(e);
        }
    }


    private String doInvokeByJson(Function fcn, String data) throws ConveyorHubException {
        List<String> args = new ArrayList<>();
        args.add(data);
        final InvokeReturn invokeReturn = ledgerInteractionHelper.invokeChaincode(fcn.name(), args);
        try {
            log.debug("BEFORE -> Store Completable Future at " + System.currentTimeMillis());
            invokeReturn.getCompletableFuture().get(configManager.getConfiguration().getTimeout(), TimeUnit.MILLISECONDS);
            log.debug("AFTER -> Store Completable Future at " + System.currentTimeMillis());
            final String payload = invokeReturn.getPayload();
            return payload;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error(fcn.name().toUpperCase() + " " + e.getMessage());
            throw new ConveyorHubException(fcn.name() + " " + e.getMessage());
        }
    }


    private List<String> doQuery(Function fcn, List<String> args, boolean isCollection) throws ConveyorHubException {
        List<String> data = new ArrayList<>();
        try {
            final List<QueryReturn> queryReturns = ledgerInteractionHelper.queryChainCode(fcn.name(), args, null);
            for (QueryReturn queryReturn : queryReturns) {
                data.add(queryReturn.getPayload());
            }
            return data;
        } catch (Exception e) {
            log.error(fcn.name() + " " + e.getMessage());
            throw new ConveyorHubException(fcn.name() + " " + e.getMessage());
        }
    }


    @Override
    public Bay getBay(Item item) throws ConveyorHubException {
        String json = JsonConverter.convertToJson(item);
        List<String> args = new ArrayList<>();
        args.add(json);
        List<String> payloads = doQuery(Function.getBay, args, false);
        if (!payloads.isEmpty())
            return (Bay) JsonConverter.convertFromJson(payloads.get(0), Bay.class, false);
        return null;
    }
}
