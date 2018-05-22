package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author ascatox
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Route implements Serializable {
    @XmlElement(name="node")
    private ArrayList<Node> node;
    @XmlElement(name="item")
    private ArrayList<Item> item;

    public Route() {
        this.node = new ArrayList<>();
        this.item = new ArrayList<>();
    }

    public ArrayList<Node> getNode() {
        return node;
    }

    public void setNode(ArrayList<Node> node) {
        this.node = node;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Route{" +
                "node=" + node +
                ", item=" + item +
                '}';
    }
}
