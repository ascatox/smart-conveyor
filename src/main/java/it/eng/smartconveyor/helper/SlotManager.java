package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SlotManager {

    private Logger logger = LogManager.getLogger(SlotManager.class);

    @Autowired
    HandlerManager handlerManager;
    @Autowired
    Conveyor conveyor;

    public SlotManager() {
    }

    public Slot actuatorItemPush(List<Slot> segmentFork, int numberFork, Item item) {
        Slot forkSlot = segmentFork.get(numberFork);
        forkSlot.setItem(item);
        logger.info("item successfully pushed!!!");
        return forkSlot;

    }


    public void sensorItemIn(Item item) throws ConveyorHubException {
        logger.info("New Item going to add on loop");
        handlerManager.doInput(item);

    }
}

