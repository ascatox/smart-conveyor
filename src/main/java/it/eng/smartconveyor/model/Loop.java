package it.eng.smartconveyor.model;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author ascatox
 */
public class Loop {


    private int size;
    private CircularArrayList<Item> itemCircularFifoQueue;

    public Loop() {
        itemCircularFifoQueue = new CircularArrayList<>(100); //FIXME Hardcoded
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public CircularArrayList<Item> getItemCircularFifoQueue() {
        return itemCircularFifoQueue;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
    }

}