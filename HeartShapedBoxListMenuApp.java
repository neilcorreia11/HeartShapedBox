import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
 * COMP 1210.
 * Project_06
 * @author Neil Correia
 * @version February 24, 2023
 */
public class HeartShapedBoxListMenuApp {
   /**
    * Main method for menu.
    * @param args is not used
    * @throws FileNotFoundException - error is 
    * covered by exception 
    */
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner userInput = new Scanner(System.in);
      String newName = "";
      ArrayList<HeartShapedBox> newList = new ArrayList<HeartShapedBox>();
      HeartShapedBoxList newhsb = new HeartShapedBoxList(newName, newList);


      System.out.println("HeartShapedBox List System Menu\n"
                       + "R - Read File and Create HeartShapedBox List\n"
                       + "P - Print HeartShapedBox List\n" 
                       + "S - Print Summary\n"
                       + "A - Add HeartShapedBox\n"   
                       + "D - Delete HeartShapedBox\n"   
                       + "F - Find HeartShapedBox\n"
                       + "E - Edit HeartShapedBox\n"
                       + "Q - Quit");
      char choice = 'E';
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");

         switch (choice) {
            case 'R': 
               System.out.print("\tFile name: ");
               String fileName = userInput.nextLine();
            
               newhsb.readFile(fileName);
                           
               System.out.println("\tFile read in and "
                              + "HeartShapedBox List created\n");
               break; 
                    
            case 'P': // Print HeartShapedBoxList
               System.out.print("\n" + newhsb.toString());
               break;
               
            case 'S': 
               System.out.print("\n" + newhsb.summaryInfo() + "\n");
               break;
               
            case 'A': 
               System.out.print("\tLabel: ");
               String label = userInput.nextLine();
               System.out.print("\tRadius: ");
               double radius = Double.parseDouble(userInput.nextLine());
               System.out.print("\tHeight: ");
               double height = Double.parseDouble(userInput.nextLine());
               newhsb.addHeartShapedBox(label, radius, height);
               System.out.println("\t*** HeartShapedBox added ***\n");
               break;
         
            case 'D': 
               System.out.println("tLabel: ");
               label = userInput.nextLine();
               HeartShapedBox hsbb = newhsb.deleteHeartShapedBox(label);
               if (newhsb != null) {
                  System.out.println("\t\"" + hsbb.getLabel() + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F': 
               System.out.println("\tLabel: ");
               label = userInput.nextLine();
               if (newhsb.findHeartShapedBox(label) != null) {
                  System.out.println(newhsb.findHeartShapedBox(label) + "\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;   
               
            case 'E': 
               System.out.println("\tLabel: ");
               label = userInput.nextLine();
               System.out.println("\tRadius: ");
               radius = Double.parseDouble(userInput.nextLine());
               System.out.println("\tHeight: ");
               height = Double.parseDouble(userInput.nextLine());
               if (newhsb.findHeartShapedBox(label) != null) {
                  newhsb.editHeartShapedBox(label, radius, height);
                  System.out.print("\t\"" + label + "\" successfully "
                     + "edited\n\n");
               }
               else {
                  System.out.print("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'Q': // Quit
               break;
               
            default:  
               System.out.println("\t*** invalid code***\n"); 
         }
      
      } 
      while (choice != 'Q');   
      
   }
}
   



