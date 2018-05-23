package it.eng.smartconveyor.model;

import java.util.ArrayList;
import java.util.List;

public class SegmentBay {

    private int lenght;
    private List<Slot> slotList;
    private Bay bay;

    public SegmentBay() {

        this.slotList = new ArrayList<>();

    }


    public SegmentBay(int lenght, Bay bay) {
        this.lenght = lenght;
        this.slotList = new ArrayList<>();
        this.bay = bay;
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

    public Bay getBay() {
        return bay;
    }

    public void setBay(Bay bay) {
        this.bay = bay;
    }
}
