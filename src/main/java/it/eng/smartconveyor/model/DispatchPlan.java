package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class DispatchPlan {

    private List<Route> route;

    private List<Bay> bay;

    public DispatchPlan() {
    }

    @XmlElementWrapper(name = "routes")
    @XmlElement
    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    @XmlElementWrapper(name = "bays")
    @XmlElement
    public List<Bay> getBay() {
        return bay;
    }

    public void setBay(List<Bay> bay) {
        this.bay = bay;
    }

    @Override
    public String toString() {
        return "DispatchPlan{" +
                "route=" + route +
                ", bay=" + bay +
                '}';
    }
}
