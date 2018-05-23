package it.eng.smartconveyor.blockchain.base;

import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.fabric.FabricLedgerClient;
import it.eng.smartconveyor.exception.ConveyorHubException;

import java.util.Properties;

/**
 * @author ascatox
 * This class decides the type of blockchain we can implement
 */
public final class BlockchainFactory {
    /**
     * @param type describer the type of blockchain
     */
    //private static Properties resourceBundle = ResourceBundle.getBundle("application", java.util.Locale.getDefault());
    private static Properties properties = null;
    private static String type = "";



    public LedgerClient getType() throws ConveyorHubException {
            return new FabricLedgerClient();
    }
}
