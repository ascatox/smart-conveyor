package it.eng.smartconveyor.model;

/**
 * @author ascatox
 */
public enum Preference {
   FRIDGE, OVEN, WASHING_MACHINE;

   private String type;
   private String serial;

   Preference(String type, String serial) {
      this.type = type;
      this.serial = serial;
   }

   Preference() {
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getSerial() {
      return serial;
   }

   public void setSerial(String serial) {
      this.serial = serial;
   }



}
