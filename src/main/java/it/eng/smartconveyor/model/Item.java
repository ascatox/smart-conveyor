package it.eng.smartconveyor.model;
/**
 * @author clod16

 */

public class Item {

    private int id;
    private String type;

    public Item() {
    }

    public Item(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
