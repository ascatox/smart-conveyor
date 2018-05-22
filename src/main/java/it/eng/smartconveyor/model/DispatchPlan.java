package it.eng.smartconveyor.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@XmlRootElement
@XmlAccessorType (XmlAccessType.NONE)
public class DispatchPlan {

    @XmlElement(name="route")
    private Collection<Route> route;

    @XmlElement(name="bay")
    private Collection<Bay> bay;

    public DispatchPlan() {
        this.route = new ArrayList<>();
        this.bay = new LinkedList<>();
    }

    public DispatchPlan(Collection<Route> routes, LinkedList<String> bayList) {
        this.route = new ArrayList<>();
        this.bay = new LinkedList<>();
    }


    public Collection<Route> getRoute() {
        return route;
    }

    public void setRoute(Collection<Route> route) {
        this.route = route;
    }

    public Collection<Bay> getBay() {
        return bay;
    }

    public void setBay(Collection<Bay> bay) {
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
