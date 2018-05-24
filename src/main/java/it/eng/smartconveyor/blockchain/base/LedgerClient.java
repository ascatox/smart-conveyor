package it.eng.smartconveyor.blockchain.base;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Bay;
import it.eng.smartconveyor.model.Item;
import org.springframework.stereotype.Component;

public interface LedgerClient {

    /**
     *
     * @param item
     * @return
     * @throws ConveyorHubException
     */

    Bay getBay(Item item) throws ConveyorHubException;


}