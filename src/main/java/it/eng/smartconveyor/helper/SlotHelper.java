package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SlotHelper {

    private Logger logger = LogManager.getLogger(SlotHelper.class);


    private Slot slot;
    HandlerHelper handlerHelper;

    public SlotHelper() {
    }


    public SlotHelper(Logger logger, Slot slot, HandlerHelper handlerHelper) {
        this.logger = logger;
        this.slot = slot;
        this.handlerHelper = handlerHelper;
    }

    public Slot actuatorItemPush(List<Slot> segmentFork, int numberFork, Item item) {

        Slot forkSlot = segmentFork.get(numberFork);
        forkSlot.setItem(item);
        logger.info("item successfully pushed!!!");
        return forkSlot;

    }
    public Slot sensorItemProximity( List<Slot> listOfFork, Item item){
        logger.info("Item is near the node");
         Slot slot = handlerHelper.doRoute(true, listOfFork, item);
         return slot;
    }

    public void sensorItemIn(Item item, Slot[] segmentConveyor) {
        logger.info("New Item is entering on segment");
        handlerHelper.doInput(true, item, segmentConveyor);

    }
}

