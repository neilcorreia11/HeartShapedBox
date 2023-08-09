import java.text.DecimalFormat;
/**
 * Program that stores radius, label, height, heart shaped area, 
 * lateral surface area, total surface area, 
 * and volumre of a heart shaped box.
 * 
 * Project 5
 * @author Neil Correia - Comp 1210 - Module 4
 * @version 2/10/2023
 */

public class HeartShapedBox {
   // instance variables
   private String label = "";
   private double radius = 0;
   private double height = 0;    
   
   // constructor
  
   /**
    * Sets label, radius, and height. 
    * @param labelIn string label input
    * @param radiusIn double value for radius
    * @param heightIn double value for height
    */

   public HeartShapedBox(String labelIn, double radiusIn, double heightIn) {
      setLabel(labelIn);
      setRadius(radiusIn);
      setHeight(heightIn);
   
   }
   
   // methods
   
   /** 
    * Returns label.
    * @return label 
    */
   public String getLabel() {
      return label;
   } 
   
   /**
    * Setting the label.
    * @param labelIn user String input
    * @return isSet boolean
    */
   public boolean setLabel(String labelIn) {
      boolean isSet = false;
      if (labelIn != null) {
         label = labelIn.trim();
         isSet = true;
      } else {
         isSet = false;
      }
      return isSet;
   }
   
   /** 
    * Returns radius.
    * @return radius 
    */
   public double getRadius() {
      return radius;
   }
   
   /**
    * Setting the radius.
    * @param radiusIn user double input value
    * @return isSet boolean
    */
   public boolean setRadius(double radiusIn) {
      boolean isSet = false;
      if (radiusIn > 0) {
         radius = radiusIn;
         isSet = true; 
      }
      return isSet;
   }
   
   /** 
    * Returns height.
    * @return height 
    */
   public double getHeight() {
      return height;
   }
   
   /**
    * Setting the height.
    * @param heightIn user double input value
    * @return isSet boolean
    */
   public boolean setHeight(double heightIn) {
      boolean isSet = false;
      if (heightIn > 0) {
         height = heightIn;
         isSet = true; 
      }
      return isSet;
   }
   
   /** 
    * Calculates heart shaped area.
    * @return  double value for calculated heart shaped area.
    */
   public double heartShapedArea()
   {
      return  (Math.PI * radius * radius) + (4 * radius * radius);
   }
   
   /** 
    * Calculates lateral surface area.
    * @return  double value for calculated lateral surface area.
    */
   public double lateralSurfaceArea()
   {
      return height * (4 * radius + 2 * Math.PI * radius);
   }
   
   /** 
    * Calculates total surface area.
    * @return  double value for calculated total surface area.
    */
   public double totalSurfaceArea()
   {
      return 2 * heartShapedArea() + lateralSurfaceArea();
   }
   
   /** 
    * Calculates volume.
    * @return  double value for calculated volume.
    */
   public double volume()
   {
      return height * heartShapedArea();
   }
   
   /**
    * Prints out all the information in a string.
    * @return output String
    */
   public String toString() 
   {
      DecimalFormat decimalFormat = new DecimalFormat("#,##0.0##");
      String output = "";
      output += "\nHeartShapedBox \"" + label + "\" with radius ";
      output += radius + " units and height " + height + " units:\n";
      output += "\theart shaped area = " 
         + decimalFormat.format(heartShapedArea()) + " square units\n";
      output += "\tlateral surface area = " 
         + decimalFormat.format(lateralSurfaceArea()) + " square units\n";
      output += "\ttotal surface area = " 
         +  decimalFormat.format(totalSurfaceArea()) + " square units\n";
      output += "\tvolume = " 
         +  decimalFormat.format(volume()) + " cubic units\n";   
      
      return output; 
      
        
   }
}

