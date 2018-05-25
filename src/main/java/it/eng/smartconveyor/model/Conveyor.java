package it.eng.smartconveyor.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Hashtable;
import java.util.Map;

public class Conveyor {

    private Belt belt; //Actual Belt
    private Map<String, Slot> itemAssignmentTable = new Hashtable<>(); //NOT USED
    private Map<Item, Bay> dispatchPlan; //CHAINCODE EVERY getBay
    private int indexConveyor = 0;

    public Conveyor() {
        this.itemAssignmentTable = new Hashtable<>();
        this.dispatchPlan = new Hashtable<>();
        this.belt = new Belt();
    }

    public int getIndexConveyor() {
        return indexConveyor;
    }

    public void setIndexConveyor(int indexConveyor) {
        this.indexConveyor = indexConveyor;
    }

    public Belt getBelt() {
        return belt;
    }

    public void setBelt(Belt belt) {
        this.belt = belt;
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




