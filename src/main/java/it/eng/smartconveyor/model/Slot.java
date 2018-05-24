package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author clod16
 */

public class Slot {

    private int numberSlot;
    Item item;

    public Slot() {
    }

    public Slot(int numberSlot, Item item) {
        this.numberSlot = numberSlot;
        this.item = item;
    }


    public int getNumberSlot() {
        return numberSlot;
    }


    public void setNumberSlot(int numberSlot) {
        this.numberSlot = numberSlot;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
