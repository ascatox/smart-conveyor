package it.eng.smartconveyor.helper;

import it.eng.smartconveyor.base.Simulator;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.model.Item;
import it.eng.smartconveyor.model.Segment;
import it.eng.smartconveyor.model.Slot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SegmentHelper {

    private Item item;
    private Conveyor conveyor = new Conveyor();
    private Segment segment = new Segment();
    private Logger logger = LogManager.getLogger(Simulator.class);


    public SegmentHelper() {
    }



    public Slot[] createSegmentConveyor() {

        int lenght = segment.getLenght();
        final  Slot[] slots = new Slot[lenght];
        return slots;
    }

    public Slot[] addItemOnSlot(Slot[] segmentArray, Item item){
        int arraySize = segmentArray.length;
        int count = 0;
        Slot slot= new Slot();
        for(int i=0; i<arraySize; i++){
            ++count;
            if(count >= arraySize){
                logger.error("end of array, overflow error ");
                break;
            }
            slot.setItem(item);//FIXME indice
            segmentArray[i]= slot;
            logger.debug("item add on slot");
            shiftItemsOnSlot(segmentArray);
            }
        return segmentArray;
    }




    public Slot[] shiftItemsOnSlot(Slot[] slots) {

        for(int i=slots.length-1; i>=0; i-- ){
            if(slots[i].getItem() == null ) --i;
            slots[i+1]= slots[i];
            logger.debug("item shift on right");
        }
        return slots;



    }


}
