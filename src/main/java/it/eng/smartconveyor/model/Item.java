package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author clod16

 */
public class Item {
    private int id;
    private String type;
    private Bay bay;

    public Item() {
    }

    public Item(int id, String type, Bay bay) {
        this.id = id;
        this.type = type;
        this.bay = bay;
    }

    public Bay getBay() {
        return bay;
    }

    public void setBay(Bay bay) {
        this.bay = bay;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", bay=" + bay +
                '}';
    }
}
