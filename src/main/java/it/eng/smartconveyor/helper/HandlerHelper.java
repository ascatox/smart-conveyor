package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.base.Simulator;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Node;
import it.eng.smartconveyor.model.Slot;
import it.eng.smartconveyor.tool.XMLReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author clod16
 */

public class HandlerHelper {
    private Logger logger = LogManager.getLogger(Simulator.class);


    SegmentHelper segmentHelper;
    XMLReader xmlReader;
    NodeHelper nodeHelper;
    Conveyor conveyor;


    public HandlerHelper() {
        this.segmentHelper= new SegmentHelper();
        this.xmlReader= new XMLReader();
        this.nodeHelper = new NodeHelper();
        this.conveyor = new Conveyor();
    }


    public void doInput(boolean isItemIn, Item item,   Slot[] segmentConveyor) {

        while(isItemIn){
            Slot[] segmentArrayUpgrade = segmentHelper.addItemOnSlot(segmentConveyor, item);
            segmentHelper.shiftItemsOnSlot(segmentArrayUpgrade);
            logger.info("ItemIn completed");
        }
    }

    public Slot doRoute(boolean isItemProximity,  ArrayList<Slot> listOfFork, Item item) {
        if(isItemProximity) {
            //if (xmlReader.readDispactPlan().isEmpty()) ;
            int numberOfFork= xmlReader.searchItemRoute(item, conveyor.getDispatchPlan() );
            logger.info("Route of Item found.....");

            Slot slot =nodeHelper.actuatorItemPush(listOfFork, numberOfFork, item);
            logger.info("Item push on fork number:" +numberOfFork);
            return slot;
        }
        return null;

    }


    private Map<String, Slot> upgradeShareState() {

        return null;
    }

    private Map<Item, Slot> upgradeConveyorState() { //TODO

        return null;
    }

    public Map<Item, ArrayList<Node>> updatePlan() { //TODO
        //XMLReader.readDispactPlan();
        return null;

    }

}
