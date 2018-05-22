package it.eng.smartconveyor.tool;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
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

    public Map<Item, ArrayList<Node>> readDispactPlan() throws ConveyorHubException {
                                                                                            //FIXME provare con jackson!!!
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DispatchPlan.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DispatchPlan dispatchPlan = (DispatchPlan) jaxbUnmarshaller.unmarshal(new File("/home/claudio/IdeaProjects/smart-conveyor/src/main/resources/dispatchPlan.xml"));  //FIXME path

            /*Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(dispatchPlan, System.out);*/


            logger.info("Object DispatchPlan build on!!!");
            System.out.println(dispatchPlan);
            Map<Item, ArrayList<Node>> map = formObjectToMap(dispatchPlan);
            return map;


        } catch (Exception e) {
            logger.error(e);
            throw new ConveyorHubException(e);
        }
    }

    private Map<Item, ArrayList<Node>> formObjectToMap(DispatchPlan dispatchPlan) {

        Map<Item, ArrayList<Node>> map = new Hashtable<>();         //FIXME maybe incorrect
        for (Route route : dispatchPlan.getRoute()) {
            Item item = route.getItem().get(0);
            map.put(item, route.getNode());
        }

       /* for(Map.Entry<Item, ArrayList<Node>> entry : map.entrySet()){
            for(Node node : entry.getValue()) {
                System.out.println(node.toString());
            } }

        map.forEach((key, value) -> System.out.println(key + ":" + value));

        for (Map.Entry<Item, ArrayList<Node>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }*/

        logger.info("Map are created from .xml");

        return map;
    }


    public int searchItemRoute(Item item, Map<Item, ArrayList<Node>> dispatchPlan) { // metodo che estrapola la biforcazione di un Item

        ArrayList<Node> nodeArrayList = dispatchPlan.get(item);
        Node node = nodeArrayList.get(1);
        logger.info("Item route extract");
        return  node.getId();
        }


    public int counterForkFromXML() {//FIXME
        int count=0;

        for(Bay bay : dispatchPlan.getBay() )

            logger.info("Number of exit bay:" +bay);
            count++;

        return count;
    }
}





