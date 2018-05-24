package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Bay;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Slot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author clod16
 */

@Component
public class HandlerManager {
    private Logger logger = LogManager.getLogger(HandlerManager.class);

    @Autowired
    LoopManager loopManager;
    @Autowired
    Conveyor conveyor;

    //@Autowired
    //private LedgerClient ledgerClient;


    public HandlerManager() {

    }


    public void doInput(boolean isItemIn, Item item, Slot[] segmentConveyor) {
    }

    public Slot doRoute(boolean isItemProximity, List<Slot> listOfFork, Item item) {
        if (isItemProximity) {
            logger.info("Item's route found.....");
            //Slot slot = nodeHelper.actuatorItemPush(listOfFork, numberOfFork, item);
            //logger.info("Item push on fork number:" + numberOfFork);
            return null;
        }
        return null;

    }


    private void upgradeSharedState() { //TODO

    }

    private void upgradeConveyorState() { //TODO

    }

    public void updatePlan() throws ConveyorHubException { //TODO

    }

}
