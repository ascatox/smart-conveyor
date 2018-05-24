package it.eng.smartconveyor.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Hashtable;
import java.util.Map;

public class Conveyor {

    private Loop loop; //Actual Loop
    private Map<String, Slot> itemAssignmentTable = new Hashtable<>(); //NOT USED
    private Map<Item, Bay> dispatchPlan; //CHAINCODE EVERY getBay

    public Conveyor() {
        this.itemAssignmentTable = new Hashtable<>();
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

    public Map<Item, Bay> getDispatchPlan() {
        return dispatchPlan;
    }

    public void setDispatchPlan(Map<Item, Bay> dispatchPlan) {
        this.dispatchPlan = dispatchPlan;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
    }

}




