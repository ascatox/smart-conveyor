package it.eng.smartconveyor.tool;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author ascatox
 */
public class XMLReader {
    private DispatchPlan dispatchPlan= new DispatchPlan();

    private Logger logger = LogManager.getLogger(XMLReader.class);


    public XMLReader() {
    }

    public void readDispactPlan() throws ConveyorHubException {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DispatchPlan.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DispatchPlan dispatchPlan = (DispatchPlan) jaxbUnmarshaller.unmarshal(new File("dispatchPlan.xml"));  //FIXME path of .xml file
            logger.info("Object Dispatchplan build on!!!");
            formObjectToMap(dispatchPlan);

        } catch (Exception e) {
            logger.error(e);
            throw new ConveyorHubException(e);
        }
    }

    private Map<Item, ArrayList<Node>> formObjectToMap(DispatchPlan dispatchPlan) {

        Map<Item, ArrayList<Node>> map = new Hashtable<>();
        for (Route route : dispatchPlan.getRoutes()) {
            Item item = route.getItem().get(0);
            map.put(item, route.getNode());
        }
        logger.info("Map are created from .xml");
        return map;
    }


    public int searchItemRoute(Item item, Map<Item, ArrayList<Node>> dispatchPlan) { //FIXME metodo che estrapola la strada da percorrere dato un Item

        ArrayList<Node> nodeArrayList = dispatchPlan.get(item);
        Node node = nodeArrayList.get(1);
        logger.info("Item route extract");
        return  node.getId();
        }


    public int counterForkFromXML() {//FIXME
        int count=0;

        for(String bay : dispatchPlan.getBay() )

            logger.info("Number of exit bay:" +bay);
            count++;

        return count;
    }
}





