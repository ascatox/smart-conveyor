package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.model.*;

import java.util.Hashtable;
import java.util.List;

public class NodeHelper {
    private Sensor sensor;
    private Actuator actuator;
    private Node node;
    HandlerHelper handlerHelper;

    public NodeHelper() {
        handlerHelper = new HandlerHelper();
    }


    public boolean actuatorItemPush() {

        return true;

    }
    public void sensorItemProximity(){
        handlerHelper.doRoute(true);
    }

    public void sensorItemIn(Item item, Slot[] segmentConveyor) {



        handlerHelper.doInput(true, item, segmentConveyor);

    }
}

