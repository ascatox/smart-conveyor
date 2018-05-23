package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Bay;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Slot;
import it.eng.smartconveyor.tool.XMLReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * @author clod16
 */

public class HandlerHelper {
    private Logger logger = LogManager.getLogger(HandlerHelper.class);

    SegmentHelper segmentHelper;
    SlotHelper nodeHelper;
    Conveyor conveyor;

    public HandlerHelper(Logger logger, SegmentHelper segmentHelper, XMLReader xmlReader, SlotHelper nodeHelper, Conveyor conveyor) {
        this.logger = logger;
        this.segmentHelper = segmentHelper;
        this.nodeHelper = nodeHelper;
        this.conveyor = conveyor;
    }

    public HandlerHelper() {

    }


    public void doInput(boolean isItemIn, Item item, Slot[] segmentConveyor) {

        while (isItemIn) {
            Slot[] segmentArrayUpgrade = segmentHelper.addItemOnSlot(segmentConveyor, item);
            segmentHelper.shiftItemsOnSlot(segmentArrayUpgrade);
            logger.info("ItemIn completed");
        }
    }

    public Slot doRoute(boolean isItemProximity, List<Slot> listOfFork, Item item) {
        if (isItemProximity) {
            logger.info("Item's route found.....");
            Slot slot = nodeHelper.actuatorItemPush(listOfFork, numberOfFork, item);
            logger.info("Item push on fork number:" + numberOfFork);
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

    public Map<Item, Bay> updatePlan() throws ConveyorHubException { //TODO
        return null;

    }

}
