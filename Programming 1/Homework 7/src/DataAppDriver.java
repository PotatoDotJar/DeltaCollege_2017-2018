//Delta College - CST 183 - Klingler 
// This program drives a statistical dataset object responsible for
// calculations on a file of integers.

import java.io.*;
import javax.swing.JOptionPane;

public class DataAppDriver 
{
	public static void main( String args[] )  throws IOException
	{
		StatsDataset myData;        // Object to store and manage stats data
		String outputMessage;       // String to be displayed at end
		int sum, max, min, numPositive, numNegative, numPrime;      
		double average;

		// Construct object and initialize with input values
		myData = new StatsDataset("statdata.txt");

		// Initiate output message
		outputMessage = "Statistical Summary" +  "\n";

		// Peform method calls to determine statistical parameters
		sum         = myData.calcSum();       
		average     = myData.calcAverage();   
		max         = myData.getMax();
		min         = myData.getMin();
		numPositive = myData.countPositives();
		numNegative = myData.countNegatives();
		numPrime    = myData.countPrimes();

		// Forulate output message string for good results
		outputMessage += "Sum of all data: " + sum + "\n";
		outputMessage += "Max value:       " + max + "\n";
		outputMessage += "Min value:       " + min + "\n";
		outputMessage += String.format("Average of numbers is: %5.1f\n",average);
		outputMessage += "Positive values:       " + numPositive + "\n";
		outputMessage += "Negative values:       " + numNegative + "\n";
		outputMessage += "Prime values:       " + numPrime;

		// Show final output dialog
		JOptionPane.showMessageDialog( null, outputMessage);

		System.exit(0);

	}
}  
