package it.eng.smartconveyor.simulate;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.helper.HandlerManager;
import it.eng.smartconveyor.helper.SlotManager;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    @Autowired
    private  SlotManager slotManager;

    public Simulator() {
    }


    public void simulate() throws ConveyorHubException {
            logger.info("Simulation starts!!!");
            Item item = new Item();   //FIXME read item from file!!!
            this.slotManager.sensorItemIn(item);     //first OP: add item in the loop









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