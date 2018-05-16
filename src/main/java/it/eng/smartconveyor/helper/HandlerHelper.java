package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Node;
import it.eng.smartconveyor.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author clod16
 */

public class HandlerHelper {
    SegmentHelper segmentHelper;
    XMLReader xmlReader;
    NodeHelper nodeHelper;


    public HandlerHelper() {
        this.segmentHelper= new SegmentHelper();
        this.xmlReader= new XMLReader();
        this.nodeHelper = new NodeHelper();
    }


    public void doInput(boolean isItemIn, Item item,   Slot[] segmentConveyor) {

        while(isItemIn){
            Slot[] segmentArrayUpgrade = segmentHelper.addItemonSlot(segmentConveyor, item);
            segmentHelper.shiftItemsOnSlot(segmentArrayUpgrade);
        }
    }

    public void doRoute(boolean isItemProximity,  List<ArrayList<Slot>> listofFork, Item item) {
        if(isItemProximity) {
            if (xmlReader.readDispactPlan().isEmpty()) ;
            int numberofFork= xmlReader.searchItemRoute(item.getId());
            nodeHelper.actuatorItemPush(listofFork, numberofFork);
        }




    }

    public Map<Item, Map<Node, Integer>> updatePlan() {
        //XMLReader.readDispactPlan();
        return null;

    }

}
