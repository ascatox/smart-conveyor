package it.eng.smartconveyor.blockchain.base;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Item;

import java.util.Collection;

public interface LedgerClient {


    void getBay(Item item) throws ConveyorHubException;


}