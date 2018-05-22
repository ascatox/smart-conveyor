package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author clod16

 */
@XmlAccessorType(XmlAccessType.NONE)
public class Node extends Slot {
    @XmlAttribute
    private int id;
    private Sensor sensor;
    private Actuator actuator;
    @XmlAttribute
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
