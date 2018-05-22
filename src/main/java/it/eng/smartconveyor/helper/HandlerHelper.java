package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.exception.ConveyorHubException;
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
    private Logger logger = LogManager.getLogger(HandlerHelper.class);


    SegmentHelper segmentHelper;
    XMLReader xmlReader;
    NodeHelper nodeHelper;
    Conveyor conveyor;

    public HandlerHelper(Logger logger, SegmentHelper segmentHelper, XMLReader xmlReader, NodeHelper nodeHelper, Conveyor conveyor) {
        this.logger = logger;
        this.segmentHelper = segmentHelper;
        this.xmlReader = xmlReader;
        this.nodeHelper = nodeHelper;
        this.conveyor = conveyor;
    }

    public HandlerHelper() {

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
            logger.info("Item's route found.....");

            Slot slot =nodeHelper.actuatorItemPush(listOfFork, numberOfFork, item);
            logger.info("Item push on fork number:" +numberOfFork);
            return slot;
        }
        return null;

    }


    private Map<String, Slot> upgradeShareState() { //TODO

        return null;
    }

    private Map<Item, Slot> upgradeConveyorState() { //TODO

        return null;
    }

    public Map<Item, List<Node>> updatePlan() throws ConveyorHubException { //TODO

        Map<Item, List<Node>>map = xmlReader.readDispactPlan();
        return map;

    }

}
