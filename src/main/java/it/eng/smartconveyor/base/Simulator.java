package it.eng.smartconveyor.base;

import it.eng.smartconveyor.helper.HandlerHelper;
import it.eng.smartconveyor.helper.NodeHelper;
import it.eng.smartconveyor.helper.SegmentHelper;
import it.eng.smartconveyor.helper.XMLReader;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * @author clod16
 */

public final class Simulator {
    private Logger logger = LogManager.getLogger(Simulator.class);
    private Slot slot;
    private Segment segment;
    private Node node;
    private Conveyor conveyor;
    private SegmentHelper segmentHelper;
    private NodeHelper nodeHelper;
    private HandlerHelper handlerHelper;
    XMLReader xmlReader;

    private static final int CLOCK = 10 * 1000; //seconds

    public Simulator() {
        this(null, null, null , null);
    }

    public Simulator(Slot slot, Segment segment, Node node, Conveyor conveyor) {
        this.slot = slot;
        this.segment = segment;
        this.node = node;
        this.conveyor = conveyor;

        this.handlerHelper = new HandlerHelper();
        this.segmentHelper = new SegmentHelper();
        this.nodeHelper = new NodeHelper();
        this.xmlReader = new XMLReader();
    }


    public void simulate() {
        //init Plan

        handlerHelper.updatePlan();

        //init();
                                                                            //SEE @ascatox
        Slot[] segmentConveyor = segmentHelper.createSegmentConveyor();   //FIXME create init() to inizialize all data structure
        int sizeArray = segmentConveyor.length;
        segmentConveyor[0] = node;
        segmentConveyor[sizeArray]= node;
        int count = xmlReader.counterForkFromXML();
        List<ArrayList<Slot>> listofFork= creatFork(count);
        logger.info("Segment created... \n Node created... \n SegmentFork created");


        instantiateTimer();
        try {
            List<Item> itemList = new ArrayList<>();
            for (Item key : conveyor.getDispatchPlan().keySet())
                itemList.add(key);
            logger.info("Item extract from dispatch plan" + itemList );
            for (int j = 0; j < itemList.size(); j++) {
                nodeHelper.sensorItemIn(itemList.get(j), segmentConveyor);
                logger.info("Item in on Conveyor");
                Slot[] segmentArrayUpgrade = segmentHelper.addItemonSlot(segmentConveyor, itemList.get(j));
                logger.info("Item added on segment");
                segmentHelper.shiftItemsOnSlot(segmentArrayUpgrade);
                logger.info("All item shift to right");
                if(segmentArrayUpgrade[j+1] == node)
                    logger.info("Caution, next slot is a Node....");
                    nodeHelper.sensorItemProximity(listofFork, itemList.get(j));


            }
        }catch (Exception e){
        }

    }


    private void instantiateTimer() {
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("Simulator started at: " + System.currentTimeMillis());
                doSimulate();
            }
        }, CLOCK, CLOCK);
    }

    private void doSimulate() {


    }

    public void init(){

    }
    public  List<ArrayList<Slot>>  creatFork(int count){
        int size =0;
        List<ArrayList<Slot>> listofFork = new ArrayList<>();
        while(size<count){
            listofFork.add(new ArrayList<Slot>());
            size += 1;

        }
        return listofFork;



    }

    //Segment operation
    private void moveItem(Item item) {

    }

    //Slot operation
    private Map<String, Slot> upgradeShareState() {

        return null;
    }

    private Map<Item, Slot> upgradeConveyorState() {

        return null;
    }


    //Node operation
    private void readItem() {
    }

    private void pushItem() {
    }


}
