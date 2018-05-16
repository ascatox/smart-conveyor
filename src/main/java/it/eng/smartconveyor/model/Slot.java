package it.eng.smartconveyor.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author clod16

 */

 public class Slot {

    private int positionItem;
    Collection<Item> items = new ArrayList<>();

    public Slot() {
    }

    public Slot(int positionItem, Collection<Item> items) {
        this.positionItem = positionItem;
        this.items = new ArrayList<>();
    }

    public int getPositionItem() {
        return positionItem;
    }

    public void setPositionItem(int positionItem) {
        this.positionItem = positionItem;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
