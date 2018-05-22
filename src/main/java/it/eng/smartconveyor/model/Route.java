package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ascatox
 */
public class Route implements Serializable {
    private List<Node> node;
    private Item item;

    public Route() {
    }

    @XmlElementWrapper(name = "nodes")
    @XmlElement
    public List<Node> getNode() {
        return node;
    }

    public void setNode(List<Node> node) {
        this.node = node;
    }

    @XmlElement
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
