package it.eng.smartconveyor.base;

import it.eng.smartconveyor.helper.HandlerHelper;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

/**
 * @author clod16
 */

public final class Simulator {
    private Logger logger = LogManager.getLogger(Simulator.class);
    private Slot slot;
    private Segment segment;
    private Node node;
    private Conveyor conveyor;

    private HandlerHelper handlerHelper;

    private static final int CLOCK = 10 * 1000; //seconds

    public Simulator() {
        this(null, null, null , null);
    }

    public Simulator(Slot slot, Segment segment, Node node, Conveyor conveyor) {
        this.slot = slot;
        this.segment = segment;
        this.node = node;
        this.conveyor = conveyor;

        this.handlerHelper = new HandlerHelper();
    }

    public void simulate() {
        //init Plan
        handlerHelper.updatePlan();
        instantiateTimer();
    }


    private void instantiateTimer() {
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("Simulator started at: " + System.currentTimeMillis());
                doSimulate();
            }
        }, CLOCK, CLOCK);
    }

    private void doSimulate() {


    }

    //Segment operation
    private void moveItem(Item item) {

    }

    //Slot operation
    private Map<String, Slot> upgradeShareState() {

        return null;
    }

    private Map<Item, Slot> upgradeConveyorState() {

        return null;
    }


    //Node operation
    private void readItem() {
    }

    private void pushItem() {
    }


}
