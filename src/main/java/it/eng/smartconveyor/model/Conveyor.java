package it.eng.smartconveyor.model;

import java.util.Hashtable;
import java.util.Map;

public class Conveyor {

    private Loop loop; //Actual Loop
    private Map<String, Slot> itemAssignmentTable = new Hashtable<>(); //NOT USED
    private Map<Item, Slot> conveyorState; //EVERY CLOCK CYCLE
    private Map<Item, Bay> dispatchPlan; //CHAINCODE EVERY getBay

    public Conveyor() {
        this.itemAssignmentTable = new Hashtable<>();
        this.conveyorState = new Hashtable<>();
        this.dispatchPlan = new Hashtable<>();
        this.loop = new Loop();
    }

    public Loop getLoop() {
        return loop;
    }

    public void setLoop(Loop loop) {
        this.loop = loop;
    }

    public Map<String, Slot> getItemAssignmentTable() {
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

}




