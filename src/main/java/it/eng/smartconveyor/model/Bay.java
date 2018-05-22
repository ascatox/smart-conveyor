package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class Bay {
    private int id;

    public Bay() {
    }

    public Bay(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    @XmlAttribute(name="id")
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bay{" +
                "id=" + id +
                '}';
    }
}
