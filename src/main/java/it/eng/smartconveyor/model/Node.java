package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.*;

/**
 * @author clod16

 */
@XmlAccessorType(XmlAccessType.NONE)
public class Node extends Slot {
    @XmlAttribute
    private int id;
    @XmlAttribute
    private int fork;

    @XmlTransient
    private Sensor sensor;
    @XmlTransient
    private Actuator actuator;


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
    public void setId(int id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public int isFork() {
        return fork;
    }
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
