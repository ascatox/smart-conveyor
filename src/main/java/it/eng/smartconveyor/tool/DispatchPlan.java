package it.eng.smartconveyor.tool;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@XmlRootElement
public class DispatchPlan {

    private Collection<Route> routes;
    private Collection<String> bay;

    public DispatchPlan() {
        this.routes = new ArrayList<>();
        this.bay = new LinkedList<>();
    }

    public DispatchPlan(Collection<Route> routes, LinkedList<String> bayList) {
        this.routes = new ArrayList<>();
        this.bay = new LinkedList<>();
    }


    public Collection<Route> getRoutes() {
        return routes;
    }
    @XmlElement
    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }

    public Collection<String> getBay() {
        return bay;
    }
    @XmlElement
    public void setBay(Collection<String> bay) {
        this.bay = bay;
    }
}
