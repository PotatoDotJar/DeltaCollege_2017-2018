import java.util.Random;
import javax.swing.JOptionPane;

public class TwoDice 
{
    public static void main( String args[] )
    {
        int die1, die2;
          
        Random randomNumbers = new Random();   // Random number instance
   
        // Throw two dice
        die1 = randomNumbers.nextInt(6) + 1;  
        die2 = randomNumbers.nextInt(6) + 1;   

        String outputString =  "You threw a " + die1 + " and a " + die2 + "\n";
        
        if((die1 == 2) && (die2 == 2)) {
        	outputString += "Doubles";
        }
        else if((die1 == 1) && (die2 == 1)) {
        	outputString += "Snake Eyes";
        }
        else if((die1 + die2) == 7) {
        	outputString += "Lucky 7";
        }

        JOptionPane.showMessageDialog( null, outputString);

        System.exit( 0 );  // Terminate application

    } // end main

} // end class 