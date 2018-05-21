package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.base.Simulator;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.logging.Slf4JLoggingSystem;

import java.util.ArrayList;
import java.util.Collection;

public class NodeHelper {
    private Logger logger = LogManager.getLogger(Simulator.class);


    private Sensor sensor;
    private Actuator actuator;
    private Node node;
    HandlerHelper handlerHelper;

    public NodeHelper() {
        handlerHelper = new HandlerHelper();
    }


    public boolean actuatorItemPush(ArrayList<Slot> segmentFork, int numberFork, Item item) {

        Slot forkSlot = segmentFork.get(numberFork);
        forkSlot.setItem(item);
        return true;

    }
    public void sensorItemProximity( ArrayList<Slot> listOfFork, Item item){
        handlerHelper.doRoute(true, listOfFork, item);
    }

    public void sensorItemIn(Item item, Slot[] segmentConveyor) {



        handlerHelper.doInput(true, item, segmentConveyor);

    }
}

