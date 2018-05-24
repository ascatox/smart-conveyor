package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Slot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoopManager {

    private Logger logger = LogManager.getLogger(LoopManager.class);
    @Autowired
    private Conveyor conveyor;

    public LoopManager() {
    }

    public void addItemOnSlot() {
    }


    public void shiftItemsOnSlot() {
        logger.info(("No item on loop conveyor..."));
    }
}
