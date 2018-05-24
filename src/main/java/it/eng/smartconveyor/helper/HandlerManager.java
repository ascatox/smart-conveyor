package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.blockchain.base.LedgerClient;
import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Bay;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Slot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author clod16
 */

@Component
public class HandlerManager {
    private Logger logger = LogManager.getLogger(HandlerManager.class);


    @Autowired
    Conveyor conveyor;

    @Autowired
    private LedgerClient ledgerClient;


    public HandlerManager() {

    }


    public void doInput(Item item) throws ConveyorHubException {

        Slot slot = new Slot();
        slot.setItem(item);
        this.conveyor.getLoop().getSlotList().add(slot);
        logger.info("Item add on loop with id:" + item.getId());
        Bay bay = doRoute(item); //query to chaincode for extract
        item.setBay(bay);
        upgradeConveyorState(); //upgrade conveyor map
    }

    public Bay doRoute(Item item) throws ConveyorHubException {
        logger.info("Searching the bay for this item:" + item.getId());
        Bay bay = ledgerClient.getBay(item);
        logger.info("Chaincode answer:" + bay.getId());
        return bay;
    }


    public void doMovement(Item item) {

    }


    private void upgradeSharedState() { //TODO

    }

    private void upgradeConveyorState() { //TODO

    }

    public void updatePlan() throws ConveyorHubException { //TODO

    }


}
