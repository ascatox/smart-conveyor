package it.eng.smartconveyor.helper;

import com.google.common.collect.EvictingQueue;
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


    public void doInput(Item item, int index) throws ConveyorHubException {

        Item[] items = this.conveyor.getLoop().getItemConveyor();    //item add on array
        items[0] = item;
        this.conveyor.getLoop().setItemConveyor(doShift(items));  //upgrade the array after shift
        Bay bay = doRoute(item);            //search the bay correctly for this item
        doUpdatePlan(item, bay);            //upgrade the conveyor map

  /*      this.conveyor.getLoop().getItemEvictingQueue().offer(item);
        logger.info("Item add on loop with id:" + item.getId());
        Bay bay = doRoute(item); //query to chaincode for extract
        item.setBay(bay);
        doUpdatePlan(item, bay); //upgrade plan*/
    }

    public Bay doRoute(Item item) throws ConveyorHubException {
        logger.info("Searching the bay for this item:" + item.getId());
        Bay bay = new Bay(); //FIXME HardCoded
        bay.setId("3");
        //Bay bay = ledgerClient.getBay(item);
        //logger.info("Chaincode answer:" + bay.getId());
        return bay;
    }


    public void doMovement(Item item) {
    }


    private void upgradeSharedState() {
        //TODO
    }


    public void doUpdatePlan(Item item, Bay bay) throws ConveyorHubException { //TODO
        this.conveyor.getDispatchPlan().put(item, bay);
    }

    public void doExitFromConveyor() {
        logger.info("item successfully pushed!!!");
        EvictingQueue<Item> itemEvictingQueue = conveyor.getLoop().getItemEvictingQueue();
        for (int i = 0; i < itemEvictingQueue.size(); i++) {
            Item item = itemEvictingQueue.peek();
            int bayId = Integer.parseInt(item.getBay().getId());
            if (bayId == i) {
                if (null != itemEvictingQueue) {
                    itemEvictingQueue.remove(i);
                    logger.info("Item " + item.toString() + " removed from Bay " + item.getBay().toString());
                }
            }
        }
    }

    public boolean isEmptyConveyor() { //FIXME Only one is correct
        logger.info("Conveyor capacity " + this.conveyor.getLoop().getItemEvictingQueue().size());
        //  return this.conveyor.getLoop().getItemCircularFifoQueue().isAtFullCapacity()
        //        || this.conveyor.getLoop().getItemCircularFifoQueue().isFull();
        return false;

    }

    public Item[] doShift(Item[] items) {

        for (int i = items.length-1; i >= 0; i--) {
            if (items[i] != null)
            items[i+1] = items[i];
        }
        return  items;
    }

}
