package it.eng.smartconveyor.tool;

import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Node;

import java.util.ArrayList;

public class Route {

    private ArrayList<Node> node;
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
}
