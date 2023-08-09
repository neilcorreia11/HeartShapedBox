import java.util.Scanner;
/**
 * Program that prints label, radius, and height.
 * 
 * Project 5
 * @author Neil Correia - Comp 1210 - Module 4
 * @version 2/10/2023
 */
public class HeartShapedBoxApp {
   /**
    * Prints label, radius, and height. 
    * @param args Command line arguments - not used.
    */

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter label, radius, and " 
         + "height for a heart shaped box.");
      System.out.print("\tlabel: ");
      String label = scan.nextLine();
      
      System.out.print("\tradius: ");
      double nradius = Double.parseDouble(scan.nextLine());  
      
      System.out.print("\theight: ");
      double nheight = Double.parseDouble(scan.nextLine());
     
      if (nheight <= 0) {
         System.out.println("Error: height must be greater than zero.");
         return;
         
      }
      if (nradius <= 0) {
         System.out.println("Error: radius must be greater than zero.");
         return;
         
      }

      HeartShapedBox hsb = new HeartShapedBox(label, nradius, nheight);
      System.out.println("\t" + hsb);
     
   }

}