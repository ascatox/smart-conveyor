package it.eng.smartconveyor.base;

import it.eng.smartconveyor.model.*;

import java.util.Map;

/**
 * @author clod16

 */

public class Simulator {
    Slot slot;
    Segment segment;
    Node node;
    Conveyor conveyor;

    public Simulator() {
    }


    public Simulator(Slot slot, Segment segment, Node node, Conveyor conveyor) {
        this.slot = slot;
        this.segment = segment;
        this.node = node;
        this.conveyor = conveyor;
    }

    public void simulate(){}


    //Segment operation
    private void moveItem(Item item){

    }

    //Slot operation
    private Map<String, Slot>  upgradeShareState(){

        return null;
    }
    private  Map<Item, Slot> upgradeConveyorState(){

        return null;
    }


    //Node operation
    private void readItem(){}
    private void pushItem(){}




}
