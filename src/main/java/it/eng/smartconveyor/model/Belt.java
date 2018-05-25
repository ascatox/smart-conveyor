package it.eng.smartconveyor.model;

import com.google.common.collect.EvictingQueue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author ascatox
 */
public class Belt {


    private Item[] itemConveyor;
    //private EvictingQueue<Item> itemEvictingQueue;
    private int size;

    public Belt() {
        this.itemConveyor = new Item[100];
       // this.itemEvictingQueue = EvictingQueue.create(100);
        //FIXME Hardcoded
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

   // public EvictingQueue<Item> getItemEvictingQueue() {
   //     return itemEvictingQueue;
   // }

    public Item[] getItemConveyor() {
        return itemConveyor;
    }

    public void setItemConveyor(Item[] itemConveyor) {
        this.itemConveyor = itemConveyor;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
    }

}