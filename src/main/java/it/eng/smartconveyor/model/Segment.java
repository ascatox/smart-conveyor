package it.eng.smartconveyor.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ascatox
 */
public class Segment {

    protected int lenght;
    protected List<Slot> slotList;

    public Segment() {
        slotList= new ArrayList<>();

    }

    public Segment( int lenght) {
        this.lenght = lenght ;
        slotList= new ArrayList<>();
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }


    public List<Slot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }
}
