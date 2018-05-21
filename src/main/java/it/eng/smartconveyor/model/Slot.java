package it.eng.smartconveyor.model;

/**
 * @author clod16

 */

 public class Slot {

    private int positionItem;
    Item item;

    public Slot() {
    }

    public Slot(int positionItem, Item item) {
        this.positionItem = positionItem;
        this.item = item;
    }

    public int getPositionItem() {
        return positionItem;
    }

    public void setPositionItem(int positionItem) {
        this.positionItem = positionItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
