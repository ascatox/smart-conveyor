package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAttribute;

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
    @XmlAttribute
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
