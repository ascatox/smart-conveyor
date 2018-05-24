package it.eng.smartconveyor.model;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ascatox
 */
public class Loop {

    @Value("${slotList.size}")
    private int size;
    private CircularFifoQueue<Slot> slotList;

    public Loop() {
        slotList = new CircularFifoQueue<>(100); //FIXME Hardcoded
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public CircularFifoQueue<Slot> getSlotList() {
        return slotList;
    }


}
