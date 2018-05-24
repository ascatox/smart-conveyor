package it.eng.smartconveyor.simulate;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.helper.HandlerManager;
import it.eng.smartconveyor.model.*;
import it.eng.smartconveyor.tool.JsonConverter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author clod16
 */
@Component
public final class Simulator {
    private Logger logger = LogManager.getLogger(Simulator.class);

    @Autowired
    private Conveyor conveyor;
    @Autowired
    private HandlerManager handlerManager;
    private int index = 0;

    public Simulator() {
    }

    public void simulate() throws ConveyorHubException {
        logger.info("Simulation step at: " + new Date());
        if (!handlerManager.isEmptyConveyor()) {
            //Insert in Belt
            Item item = new Item(RandomStringUtils.randomAlphanumeric(10));   //FIXME read item from file!!!
            handlerManager.doInput(item, index);
            //Exit from Belt
            handlerManager.doExitFromConveyor();
        }
        logger.info("Conveyor elements: ");
        conveyor.getLoop().getItemCircularFifoQueue().forEach(i -> {
            try {
                logger.info(index+" -> "+ JsonConverter.convertToJson(i));
                index++;
            } catch (ConveyorHubException e) {
                logger.error(e);
            }
        });
        index++;
    }


    public void startup() throws ConveyorHubException {
        try {
            //Init loop
            //Init baie
            logger.info("Simulation starts");
        } catch (Exception e) {
            throw new ConveyorHubException(e.getMessage());
        }
    }

}