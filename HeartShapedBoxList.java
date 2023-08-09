import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Creates an arraylist class from the HeartShapedBox class.
 *
 * @author Neil Correia
 * @version February 18, 2022
 */

public class HeartShapedBoxList {
   
   // instance variables
   private String name;
   private ArrayList<HeartShapedBox> objects = new ArrayList<HeartShapedBox>();
        
   // constructor
   
   /**
    * Creates the constructor.
    * @param nameList String
    * @param inputObj ArrayList
    */ 
   public HeartShapedBoxList(String nameList, 
      ArrayList<HeartShapedBox> inputObj) {
   
      name = nameList;
      objects = inputObj;
      
   }
   // methods
   /**
    * Gets name.
    *
    * @return name represents name of the list
    */
   public String getName() {
      return name;
   }
   /**
    * Returns number of HeartShapedBox objects in an arraylist.
    *
    * @return number of HeartShapedBoxes in ArrayList
    */
   public int numberOfHeartShapedBoxes() {
      return objects.size();
   }    
   /**
    * Returns the grand total Surface Area of objects.
    *
    * @return total surface area of objects
    */
   public double grandTotalSurfaceArea() {
      int index = 0;
      double listGrandTotalSurfaceArea = 0;
      while (index < objects.size()) {
         listGrandTotalSurfaceArea += objects.get(index).totalSurfaceArea();
         index++;
      }
      return listGrandTotalSurfaceArea;
   }
   /**
    * Returns the total volume of objects.
    *
    * @return total volume of objects
    */
   public double totalVolume() {
      int index = 0;
      double listTotalVolume = 0;
      while (index < objects.size()) {
         listTotalVolume += objects.get(index).volume();
         index++;
      }
      return listTotalVolume; 
   }  
  
   /**
    * Returns average Surface Area of objects.
    *
    * @return average Surface Area of objects
    */     
   public double averageTotalSurfaceArea() {                       
      return grandTotalSurfaceArea() / objects.size();
   
   }
   /**
    * Returns the average volume of objects.
    *
    * @return average volume of objects
    */
   public double averageVolume() {
      return totalVolume() / objects.size();

   }

   /**
    * Prints information of HeartShapedBox Test List.
    *
    * @return output calling the HeartShapedBox toString.
    * method for each HeartShapedBox in HeartShapedBoxList.
    */
   public String toString() {
      String output = "";
      output += "----- " + "HeartShapedBox Test List" + " -----";
      int i = 0;
      while (i < objects.size()) {
         HeartShapedBox hsb = objects.get(i);
         output += hsb.toString();
         i++;
      }
      return output;
   }
   /**
    * Prints summary of HeartShapedBox List Information.
    *
    * @return output calling the HeartShapedBox String.
    */
   public String summaryInfo() {  
      DecimalFormat decimalFormat = new DecimalFormat("#,##0.0##");
      String output = "\n";
      output += "----- Summary for " + name + " -----" + "\n";
      output += "Number of HeartShapedBoxes: " 
         + numberOfHeartShapedBoxes() + "\n";
      output += "Total Surface Area: " 
         + decimalFormat.format(grandTotalSurfaceArea()) + " square units\n";
      output += "Total Volume: " 
         + decimalFormat.format(totalVolume()) + " cubic units\n";
      output += "Average Surface Area: " 
         + decimalFormat.format(averageTotalSurfaceArea()) + " square units\n";
      output += "Average Volume: " 
         + decimalFormat.format(averageVolume()) + " cubic units\n";
      return output;      
   }
   /**
    * Returns HeartShapedBox array list.
    * 
    * @return HeartShapedBox array list of all HeartShapedBox objects.
    *
    */
    
   public ArrayList<HeartShapedBox> getList() {
      return objects;
   }
   /**
    * Returns HeartShapedBox array list.
    *
    * @param fileName is name of file
    * @throws FileNotFoundException required by WebCat. 
    * @return heartsblist
    */ 
   public HeartShapedBoxList readFile(String fileName) 
      throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileName.trim()));
      name = scanFile.nextLine();
      ArrayList<HeartShapedBox> aList = new ArrayList<HeartShapedBox>();
      
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine().trim();
         double radius = Double.parseDouble(scanFile.nextLine().trim());
         double height = Double.parseDouble(scanFile.nextLine().trim());
         HeartShapedBox heartsb = new HeartShapedBox(label, radius, height);
         aList.add(heartsb);
      }
      HeartShapedBoxList heartsbList = new HeartShapedBoxList(name, aList);
      return heartsbList;
   }
   /**
    * Creates new HeartShapedBox object in array list.
    *
    * @param labelIn String for label
    * @param radiusIn double value for radius 
    * @param heightIn double for height length
    */
   public void addHeartShapedBox(String labelIn, double radiusIn, 
      double heightIn) {
      HeartShapedBox addObject = new HeartShapedBox(labelIn, 
         radiusIn, heightIn);
      objects.add(addObject);
   }     
   /**
    * Finds HeartShapedBox in array list.
    *
    * @param labelIn is label of HeartShapedBox
    * @return heartsb or null if not found
    */
   
   public HeartShapedBox findHeartShapedBox(String labelIn) {
      for (HeartShapedBox heartsb: objects) {
         if (heartsb.getLabel().equalsIgnoreCase(labelIn)) {
            return heartsb;
         }
      }
      return null;
   }
   /**
    * Deletes HeartShapedBox from array list.
    *
    * @param labelIn is label of HeartShapedBox
    * @return HeartShapedBox
    */
          
   public HeartShapedBox deleteHeartShapedBox(String labelIn) {
      for (HeartShapedBox heartsb: objects) {
         if (heartsb.getLabel().equalsIgnoreCase(labelIn)) {
            HeartShapedBox store = heartsb;
            objects.remove(heartsb);
            return store;
         }
      }
      return null;
   }      
   /**
    * Sets radius and height of HeartShapedBox object.
    * @param labelIn sets label
    * @param radiusIn sets radius
    * @param heightIn sets height
    * @return boolean returns true or false depending on input
    */
    
   public boolean editHeartShapedBox(String labelIn, double radiusIn,
      double heightIn) {  
      for (HeartShapedBox heartsb: objects) {
         if (heartsb.getLabel().equals(labelIn)) {
            heartsb.setRadius(radiusIn);
            heartsb.setHeight(heightIn);
            return true;
         } else {
            return false;
         }
      }
      return false;
   }
            

}