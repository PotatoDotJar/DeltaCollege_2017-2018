// Delta College - CST 183 - Klingler  
// This program prompts the user for two positive numbers and displays
// the sum of two numbers to the user.  Includes exception handling for 
// String-to-number conversion action.

import javax.swing.JOptionPane;  

public class AdditionException 
{
   // main method begins execution of Java application
   public static void main( String args[] )
   {
      String firstNumber;   // First string entered by user
      String secondNumber;  // Second string entered by user

      int number1 = 0;;     // First number to add
      int number2 = 0;      // Second number to add
      int sum;              // Sum of number1 and number2

      // Read in first numbers from user as strings
      firstNumber = JOptionPane.showInputDialog( "Enter first positive integer" );
      secondNumber = JOptionPane.showInputDialog( "Enter second positive integer" );
 
      boolean errorDetected = false;     // Assume no error
     
      try  // Attempt to perform number conversion
      {
         number1 = Integer.parseInt( firstNumber );     
         number2 = Integer.parseInt( secondNumber );
      }
      // Catch any number format exception.  Display error message
      // for invalid numbers.
      catch (NumberFormatException theException)
      {
         JOptionPane.showMessageDialog(
             null, "Invalid input format", "ALERT",
             JOptionPane.WARNING_MESSAGE );
         errorDetected = true;                 // Mark an error detected
      }
      
      // Asserting valid integers, check to insure they are in range.
      if (number1 < 0 || number2 < 0)
      {
         JOptionPane.showMessageDialog(
             null, "Numbers must be positive", "ALERT",
             JOptionPane.WARNING_MESSAGE );
         errorDetected = true;                 // Mark an error detected
      }
         
      // If no error detected, calculate and display sum
      if ( ! errorDetected )
      {
         sum = number1 + number2;  
         JOptionPane.showMessageDialog( null, "The sum is " + sum);         
      }

      System.exit( 0 );   

   } 

} 
