package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Bay;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author clod16
 */

@Component
public class HandlerManager {
    private Logger logger = LogManager.getLogger(HandlerManager.class);


    @Autowired
    Conveyor conveyor;

    //@Autowired
    //private LedgerClient ledgerClient;


    public HandlerManager() {

    }


    public int doInput(Item item, int index) throws ConveyorHubException {

        Item[] items = this.conveyor.getBelt().getItemConveyor();    //item add on array
        items[0] = item;
        logger.debug("Item" + item.getId() + "add on conveyor...");
        index++;
        this.conveyor.getBelt().setItemConveyor(doShift(items, index++));  //upgrade the array after shift
        Bay bay = doRoute(item);            //search the bay correctly for this item
        doUpdatePlan(item, bay);          //upgrade the conveyor map

        return index;

    }

    public Bay doRoute(Item item) throws ConveyorHubException {
        logger.info("Searching the bay for this item:" + item.getId());
        Bay bay = new Bay(); //FIXME HardCoded
        bay.setId("3");
        //Bay bay = ledgerClient.getBay(item);
        //logger.info("Chaincode answer:" + bay.getId());
        return bay;
    }

    
    private void upgradeSharedState() {
        //TODO
    }


    public void doUpdatePlan(Item item, Bay bay) throws ConveyorHubException { //TODO
        this.conveyor.getDispatchPlan().put(item, bay);
    }

    public int doExitFromConveyor(int index) {
        logger.info("item successfully pushed!!!");

        Item[] items = this.conveyor.getBelt().getItemConveyor();

        for (int i = index; i > 0; i--) {
            Item item = items[i];
            int bayId = Integer.parseInt(item.getBay().getId());
            if (bayId == i) {
                items[i] = null;
                logger.info("Item " + item.toString() + " removed from Bay " + item.getBay().toString());
                index--;
            }
        }
        return index;
    }

    public boolean isEmptyConveyor() { //FIXME Only one is correct
        logger.info("Conveyor capacity " + this.conveyor.getBelt().getItemConveyor().length);
        //  return this.conveyor.getBelt().getItemCircularFifoQueue().isAtFullCapacity()
        //        || this.conveyor.getBelt().getItemCircularFifoQueue().isFull();
        return false;

    }

    public Item[] doShift(Item[] items, int index) {

        for (int i = items.length - 1; i >= 0; i--) {
            if (items[i] != null || index <= this.conveyor.getBelt().getItemConveyor().length) {
                items[i + 1] = items[i];
                logger.debug("All items on conveyor shift to right!!");
            } else {
                doCircularity();
            }
        }
        return items;
    }

    public void doCircularity() {

        Item[] items = this.conveyor.getBelt().getItemConveyor();

        Item item = items[this.conveyor.getBelt().getItemConveyor().length - 1];
        items[this.conveyor.getBelt().getItemConveyor().length - 1] = null;
        items = doShift(items, this.conveyor.getBelt().getItemConveyor().length - 1);
        this.conveyor.getBelt().setItemConveyor(items);
        items[0] = item;
        logger.debug("Item:" + item.getId() + "put in head of array!");
    }


}
