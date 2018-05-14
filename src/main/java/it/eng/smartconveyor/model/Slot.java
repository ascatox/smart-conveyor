package it.eng.smartconveyor.model;

/**
 * @author clod16

 */

 public class Slot {

     private int positionItem;

     public Slot() {
     }

     public Slot(int positionItem) {
         this.positionItem = positionItem;
     }

     public int getPositionItem() {
         return positionItem;
     }

     public void setPositionItem(int positionItem) {
         this.positionItem = positionItem;
     }




     public void upgradeSharedState(){

     }

     public void upgradeConveyorState(){

     }
}
