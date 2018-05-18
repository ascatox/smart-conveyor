package it.eng.smartconveyor.tool;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
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
           logger.debug("Object Dispatchplan build on!!!");
           formObjectToMap(dispatchPlan);

       } catch (Exception e) {
           logger.error(e);
           throw new ConveyorHubException(e);
       }
   }

    private Map<Item, Map<Node, Integer>> formObjectToMap(DispatchPlan dispatchPlan) {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<Item, Map<Node, Integer>> mapMap= objectMapper.convertValue(dispatchPlan, Map.class);           //FIXME build map ad hoc!!!!
        logger.debug("The Map build is:" +mapMap);
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





