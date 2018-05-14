package it.eng.smartconveyor.model;

/**
 * @author clod16

 */

public class Node extends Slot {

    private int id;
    private Sensor sensor;
    private Actuator actuator;

    public Node() {
    }

    public Node(int id, Sensor sensor, Actuator actuator) {
        this.id = id;
        this.sensor = sensor;
        this.actuator = actuator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Actuator getActuator() {
        return actuator;
    }

    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }

}
