package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.base.Simulator;
import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.tool.DispatchPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Map;

/**
 * @author ascatox
 */
public class XMLReader {
    
    private Logger logger = LogManager.getLogger(XMLReader.class);



    public XMLReader() {
    }

    public void readDispactPlan() throws ConveyorHubException {

       try {
           JAXBContext jaxbContext = JAXBContext.newInstance(DispatchPlan.class);
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
           DispatchPlan dispatchPlan = (DispatchPlan) jaxbUnmarshaller.unmarshal(new File("dispatchPlan.xml"));  //FIXME path of .xml file
           formObjectToMap(dispatchPlan);

       } catch (Exception e) {
           logger.error(e);
           throw new ConveyorHubException(e);
       }
   }



    private Map<Item, Map<it.eng.smartconveyor.model.Node, Integer>> formObjectToMap(DispatchPlan dispatchPlan) {
        return null;

    }


    public int searchItemRoute(String itemID) { //TODO

        int numberOfRoute = 0;
        return numberOfRoute;
    }

    public int counterForkFromXML() { //TODO
        int numberOfFork = 0;

        return numberOfFork;
    }
}





