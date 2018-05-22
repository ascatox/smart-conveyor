package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.*;

/**
 * @author clod16

 */
public class Node extends Slot {

    private int id;
    private int fork;
    private Sensor sensor;
    private Actuator actuator;


    public Node() {
    }

    public Node(int id, Sensor sensor, Actuator actuator, int fork) {
        this.id = id;
        this.sensor = sensor;
        this.actuator = actuator;
        this.fork = fork;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlTransient
    public Sensor getSensor() {
        return sensor;
    }

    @XmlAttribute
    public int isFork() {
        return fork;
    }
    public void setFork(int fork) {
        this.fork = fork;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @XmlTransient
    public Actuator getActuator() {
        return actuator;
    }
    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", sensor=" + sensor +
                ", actuator=" + actuator +
                ", fork=" + fork +
                '}';
    }
}
