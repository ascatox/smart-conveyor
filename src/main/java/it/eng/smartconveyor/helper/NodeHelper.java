package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class NodeHelper {
    private Logger logger = LogManager.getLogger(NodeHelper.class);


    private Sensor sensor;
    private Actuator actuator;
    private Node node;
    HandlerHelper handlerHelper;

    public NodeHelper() {
        handlerHelper = new HandlerHelper();
    }


    public Slot actuatorItemPush(ArrayList<Slot> segmentFork, int numberFork, Item item) {

        Slot forkSlot = segmentFork.get(numberFork);
        forkSlot.setItem(item);
        logger.info("item successfully pushed!!!");
        return forkSlot;

    }
    public Slot sensorItemProximity( ArrayList<Slot> listOfFork, Item item){
        logger.info("Item is near the node");
         Slot slot = handlerHelper.doRoute(true, listOfFork, item);
         return slot;
    }

    public void sensorItemIn(Item item, Slot[] segmentConveyor) {
        logger.info("New Item is entering on segment");
        handlerHelper.doInput(true, item, segmentConveyor);

    }
}

