
import java.util.Scanner;  

public class AveNums 
{
   public static void main(String args[])
   {
      // Declarations
      double value1, value2, value3, average;     
      
      // Instantiate keyboard object
      Scanner keyboard = new Scanner(System.in);

      // Input
      System.out.print("1st number:");
      value1 = keyboard.nextFloat();
      
      System.out.print("2nd number:");
      value2 = keyboard.nextFloat();
      
      System.out.print("3rd number:");
      value3 = keyboard.nextDouble();
      
      // Calculate average
      average = (value1 + value2 + value3) / 3.0;

      // Output results
      System.out.println("Average:" + average);

      System.exit(0);   
   }
}