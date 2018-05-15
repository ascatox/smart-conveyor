package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Segment;
import it.eng.smartconveyor.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SegmentHelper {

    private Item item;
    private Conveyor conveyor = new Conveyor();
    private Segment segment = new Segment();




    public SegmentHelper() {
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
                    move1Item1slot( segmentArray, i);
            }
        }
    }

    public void move1Item1slot(Item[] array, int i){

        for(int j=i; i < array.length; j++){
            if(array[j].equals(null)){
                break;
            }
            array[j+1]= array[j];
            array[i]= null;
            break;
        }







    }


}
