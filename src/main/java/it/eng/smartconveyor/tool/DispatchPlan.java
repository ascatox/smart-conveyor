package it.eng.smartconveyor.tool;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@XmlRootElement
public class DispatchPlan {

    private Collection<Route> routes;
    private Collection<String> bayList;

    public DispatchPlan() {
        this.routes = new ArrayList<>();
        this.bayList = new LinkedList<>();
    }

    public DispatchPlan(Collection<Route> routes, LinkedList<String> bayList) {
        this.routes = new ArrayList<>();
        this.bayList = new LinkedList<>();
    }


    public Collection<Route> getRoutes() {
        return routes;
    }
    @XmlElement
    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }

    public Collection<String> getBayList() {
        return bayList;
    }
    @XmlElement
    public void setBayList(Collection<String> bayList) {
        this.bayList = bayList;
    }
}
