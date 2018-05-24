package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.*;
import org.apache.commons.collections4.queue.CircularFifoQueue;
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
        this.conveyor.getLoop().getItemCircularFifoQueue().add(index, item);
        logger.info("Item add on loop with id:" + item.getId());
        Bay bay = doRoute(item); //query to chaincode for extract
        item.setBay(bay);
        doUpdatePlan(item, bay); //upgrade plan
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
        CircularArrayList<Item> itemCircularFifoQueue = conveyor.getLoop().getItemCircularFifoQueue();
        for (int i = 0; i < itemCircularFifoQueue.size(); i++) {
            Item item = itemCircularFifoQueue.get(i);
            int bayId = Integer.parseInt(item.getBay().getId());
            if (bayId == i) {
                if (null != itemCircularFifoQueue.get(i)) {
                    itemCircularFifoQueue.remove(i);
                    logger.info("Item " + item.toString() + " removed from Bay " + item.getBay().toString());
                }
            }
        }
    }

    public boolean isEmptyConveyor() { //FIXME Only one is correct
        logger.info("Conveyor capacity "+this.conveyor.getLoop().getItemCircularFifoQueue().size());
      //  return this.conveyor.getLoop().getItemCircularFifoQueue().isAtFullCapacity()
       //        || this.conveyor.getLoop().getItemCircularFifoQueue().isFull();
        return false;

    }

}
