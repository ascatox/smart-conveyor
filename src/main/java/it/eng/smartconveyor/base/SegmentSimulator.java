package it.eng.smartconveyor.base;

import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Segment;
import it.eng.smartconveyor.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SegmentSimulator {

    private Item item;
    private Conveyor conveyor = new Conveyor();
    private Segment segment = new Segment();




    public SegmentSimulator() {
    }

    public void createSegment() {

        final Map<Item, Slot> conveyorState = conveyor.getConveyorState();
        int lenght = segment.getLenght();
        Item[] segmentArray = new Item[lenght];
        List<Item> itemList = new ArrayList<>();

        for (Item key : conveyorState.keySet()) itemList.add(key);

        for (int i = 0; i < segmentArray.length; i++) {
            for (int j = 0; j < itemList.size(); j++) {

                    segmentArray[i] = itemList.get(j);
                    moveItem( segmentArray, itemList);
            }
        }
    }

    public void moveItem(Item[] array, List list){

        for(int i=0; i < array.length; i++){
            if(array[i].equals(null)){
                break;
            }
            array[i+1]= array[i];
        }







    }


}
