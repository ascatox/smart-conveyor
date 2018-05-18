package it.eng.smartconveyor.tool;

import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Node;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collection;

public class Route {

    private Collection<Node> nodes;
    private Collection<Item> items;

    public Route() {
        this.nodes = new ArrayList<>();
        this.items = new ArrayList<>();
    }


    public Route(Collection<Node> nodes, Collection<Item> items) {
        this.nodes = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public Collection<Node> getNodes() {
        return nodes;
    }
    @XmlElement
    public void setNodes(Collection<Node> nodes) {
        this.nodes = nodes;
    }

    public Collection<Item> getItems() {
        return items;
    }
    @XmlElement
    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
