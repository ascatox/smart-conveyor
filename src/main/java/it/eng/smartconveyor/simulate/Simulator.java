package it.eng.smartconveyor.simulate;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.helper.HandlerManager;
import it.eng.smartconveyor.helper.LoopManager;
import it.eng.smartconveyor.helper.SlotManager;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    public Simulator() {
    }


    public void simulate() throws ConveyorHubException {
            logger.info("Simulation starts!!!");
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