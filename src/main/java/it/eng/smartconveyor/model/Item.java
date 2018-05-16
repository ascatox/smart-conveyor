package it.eng.smartconveyor.model;
/**
 * @author clod16

 */

public class Item {

    private String id;
    private String type;

    public Item() {
    }

    public Item(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
