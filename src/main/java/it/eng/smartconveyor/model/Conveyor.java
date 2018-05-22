package it.eng.smartconveyor.model;

import java.util.*;

public class Conveyor {

    private Collection<Segment> segmentCollection;
    private Collection<Slot> slotCollection;

    final static Map<String, Slot> itemAssignmentTable = new Hashtable<>();
    private Map<Item, Slot> conveyorState; //TODO rappresentazione live (aggironata ogni step) della posizione di ogni item nel suo relativo slot

    private Map<Item, List<Node>> dispatchPlan;
    private String configuration; //TODO
    private Collection<Route> routes;

    public Conveyor() {
        this(new ArrayList<>(), new ArrayList<>(), new Hashtable<>(), new Hashtable<>(), null);
    }

    public Conveyor(Collection<Segment> segmentCollection, Collection<Slot> slotCollection, Map<Item, Slot> conveyorState,Map<Item, List<Node>> dispatchPlan, String configuration) {
        this.segmentCollection = segmentCollection;
        this.slotCollection = slotCollection;
        this.conveyorState = conveyorState;
        this.dispatchPlan = dispatchPlan;
        this.configuration = configuration;

        routes = new LinkedList<>();
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public Collection<Segment> getSegmentCollection() {
        return segmentCollection;
    }

    public void setSegmentCollection(Collection<Segment> segmentCollection) {
        this.segmentCollection = segmentCollection;
    }

    public Collection<Slot> getSlotCollection() {
        return slotCollection;
    }

    public void setSlotCollection(Collection<Slot> slotCollection) {
        this.slotCollection = slotCollection;
    }

    public static Map<String, Slot> getItemAssignmentTable() {
        return itemAssignmentTable;
    }

    public Map<Item, Slot> getConveyorState() {
        return conveyorState;
    }

    public void setConveyorState(Map<Item, Slot> conveyorState) {
        this.conveyorState = conveyorState;
    }

    public Map<Item, List<Node>> getDispatchPlan() {
        return dispatchPlan;
    }

    public void setDispatchPlan(Map<Item, List<Node>> dispatchPlan) {
        this.dispatchPlan = dispatchPlan;
    }

    public Collection<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }
}
