package it.eng.smartconveyor.base;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.helper.HandlerHelper;
import it.eng.smartconveyor.helper.NodeHelper;
import it.eng.smartconveyor.helper.SegmentHelper;
import it.eng.smartconveyor.tool.XMLReader;
import it.eng.smartconveyor.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Stream;

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
    private XMLReader xmlReader;

    private static final int CLOCK = 5 * 1000; //seconds

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


    public void simulate() throws ConveyorHubException {
        //init Plan
        logger.info("Simulation start!!!");

        handlerHelper.updatePlan();
        xmlReader.readDispactPlan();

        //init();
        Slot[] segmentConveyor = segmentHelper.createSegmentConveyor();   //FIXME create init() to inizialize all data structure
        int sizeArray = segmentConveyor.length;
        segmentConveyor[0] = node;
        segmentConveyor[sizeArray]= node;
        int count = xmlReader.counterForkFromXML();
        ArrayList<Slot> listOfFork= createFork(count);
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

                Stream<Slot> slotStream = Arrays.stream(segmentConveyor);
                slotStream.forEach(slot -> System.out.println(slot));

                Slot[] segmentArrayUpgrade = segmentHelper.addItemOnSlot(segmentConveyor, itemList.get(j));
                logger.info("Item added on segment");
                segmentHelper.shiftItemsOnSlot(segmentArrayUpgrade);
                logger.info("All item shift to right");

                Stream<Slot> slotStreamUpgrade = Arrays.stream(segmentArrayUpgrade);
                slotStreamUpgrade.forEach(slot -> System.out.println(slot));

                if(segmentArrayUpgrade[j+1] == node){
                    logger.info("Caution, next slot is a Node....");
                    Slot slot = nodeHelper.sensorItemProximity(listOfFork, itemList.get(j));
                    logger.info("Item are passed the fork-node and it pushed in the right way.... ");
                    int numberOfFork= xmlReader.searchItemRoute(itemList.get(j), conveyor.getDispatchPlan() );
                    listOfFork.set(numberOfFork, slot);
                    logger.info("Slot after fork upgrade with correct item!!!");

                }


            }
        } catch (Exception e) {
            logger.error(e);
            throw new ConveyorHubException(e);
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

    public void init(){  //TODO

    }


    public  ArrayList<Slot> createFork(int count){     //FIXME method for
        // exit segment after fork
        int size =0;
        ArrayList<Slot> listOfFork = new ArrayList<>();
        while(size<count){
            listOfFork.add(new Slot());
            size += 1;
        }
        logger.info("Fork created!!!");
        return listOfFork;

    }

}
