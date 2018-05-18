package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author clod16

 */

public class Node extends Slot {

    private int id;
    private Sensor sensor;
    private Actuator actuator;
    private int fork;

    public Node() {
    }

    public Node(int id, Sensor sensor, Actuator actuator, int fork) {
        this.id = id;
        this.sensor = sensor;
        this.actuator = actuator;
        this.fork = fork;
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public int isFork() {
        return fork;
    }
    @XmlAttribute
    public void setFork(int fork) {
        this.fork = fork;
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
