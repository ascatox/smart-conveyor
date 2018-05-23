package it.eng.smartconveyor.model;

import java.util.*;

public class Conveyor {

    private Segment segment;


    final static Map<String, Slot> itemAssignmentTable = new Hashtable<>(); //
    private Map<Item, Slot> conveyorState;

    private Map<Item, List<Node>> dispatchPlan;
    private String configuration; //TODO

    public Conveyor() {
        this(new ArrayList<>(), new ArrayList<>(), new Hashtable<>(), new Hashtable<>(), null);
    }

    public Conveyor(Collection<Segment> segmentCollection, Collection<Slot> slotCollection, Map<Item, Slot> conveyorState,Map<Item, List<Node>> dispatchPlan, String configuration) {
        this.conveyorState = conveyorState;
        this.dispatchPlan = dispatchPlan;
        this.configuration = configuration;

    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
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

}
