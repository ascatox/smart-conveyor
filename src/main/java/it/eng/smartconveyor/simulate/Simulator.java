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
    private int index;

    public Simulator() {
    }

    public void simulate() throws ConveyorHubException {
        logger.info("Simulation step at: " + new Date());


        if ((this.index += 1) == this.conveyor.getBelt().getItemConveyor().length) {
            handlerManager.doCircularity();
            this.index = handlerManager.doExitFromConveyor(this.index);
        } else {
            //Insert in Belt
            Item item = new Item(RandomStringUtils.randomAlphanumeric(10));
            //FIXME read item from file!!!
            this.index = handlerManager.doInput(item, this.index);
            //Exit from Belt
            handlerManager.doExitFromConveyor(this.index);
        }


    }


    public void startup() throws ConveyorHubException {
        try {
            this.index = conveyor.getIndexConveyor();
            //Init loop
            //Init baie
            logger.info("Simulation starts");
        } catch (Exception e) {
            throw new ConveyorHubException(e.getMessage());
        }
    }

}