package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.model.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Map;

/**
 * @author ascatox
 */
public class XMLReader {

    public XMLReader() {
    }
    public static void main(String argv[]) {

    //public static Map<Item, Map<it.eng.smartconveyor.model.Node, Integer>> readDispactPlan() {

        try {

            File file = new File("/home/claudio/IdeaProjects/smart-conveyor/src/main/resources/dispatchPlan.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("route");
            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i);

                System.out.println("\nCurrent Element :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    System.out.println("Item type : " + element.getAttribute("type"));
                    System.out.println("Node fork : " + element.getAttribute("fork"));


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


