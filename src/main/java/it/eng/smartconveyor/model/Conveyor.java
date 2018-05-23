package it.eng.smartconveyor.model;

import java.util.*;

public class Conveyor {

    private Segment segment;


    final static Map<String, Slot> itemAssignmentTable = new Hashtable<>(); //
    private Map<Item, Slot> conveyorState;

    private Map<Item, Bay> dispatchPlan;
    private String configuration;

    public Conveyor() {
    }


    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
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

    public Map<Item, Bay> getDispatchPlan() {
        return dispatchPlan;
    }

    public void setDispatchPlan(Map<Item, Bay> dispatchPlan) {
        this.dispatchPlan = dispatchPlan;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}




