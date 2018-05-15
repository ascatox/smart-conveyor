package it.eng.smartconveyor.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Conveyor {

    Collection<Segment> segmentCollection;
    Collection<Slot> slotCollection;

    final static Map<String, Slot> itemAssignmentTable = null;
    Map<Item, Slot> conveyorState;
    Map<Item, Map<Integer, Integer>>dispatchPlan;

    public Conveyor() {
    }

    public Conveyor(Collection<Segment> segmentCollection, Collection<Slot> slotCollection, Map<Item, Slot> conveyorState, Map<Item, Map<Integer, Integer>> dispatchPlan) {
        this.segmentCollection = segmentCollection;
        this.slotCollection = slotCollection;
        this.conveyorState = conveyorState;
        this.dispatchPlan = dispatchPlan;
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

    public Map<Item, Map<Integer, Integer>> getDispatchPlan() {
        return dispatchPlan;
    }

    public void setDispatchPlan(Map<Item, Map<Integer, Integer>> dispatchPlan) {
        this.dispatchPlan = dispatchPlan;
    }
}
