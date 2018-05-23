package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Bay {

    private int id;
    private SegmentBay segmentBay;


    public Bay() {
    }


    public Bay(int id, SegmentBay segmentBay) {
        this.id = id;
        this.segmentBay = segmentBay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SegmentBay getSegmentBay() {
        return segmentBay;
    }

    public void setSegmentBay(SegmentBay segmentBay) {
        this.segmentBay = segmentBay;
    }
}
