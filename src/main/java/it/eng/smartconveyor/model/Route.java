package it.eng.smartconveyor.model;

import java.io.Serializable;

/**
 * @author ascatox
 */
public class Route implements Serializable {
    private Item item;
    private Node node;

    public Route() {
    }

    public Route(Item item, Node node) {
        this.item = item;
        this.node = node;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
