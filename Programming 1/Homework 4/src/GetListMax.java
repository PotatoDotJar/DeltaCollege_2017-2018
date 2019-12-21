import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GetListMax {

	public static final String bigDataFilename = "data.txt";  

	public static void main(String[] args) {

		Scanner inputDataFile = null;
		
		int value;                         // Utility variable for file processing
		int numVals = 0;                   // Set counter to zero
		int numberOfEvens = 0;
		String outMsg;                     // String for final output message

		int maxVal = Integer.MIN_VALUE;   // Assume a very small max value
		int minVal = Integer.MAX_VALUE;
		

		File inputfile = new File(bigDataFilename);  

		// Check for file existence.  
		if (!inputfile.exists())
		{   
			JOptionPane.showMessageDialog( null, 
					"File was not found", 
					"File Error", 
					JOptionPane.ERROR_MESSAGE );
			System.exit(0);
		}

		// Instantiate scanner object for input
		
		try {
			inputDataFile = new Scanner(inputfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  

		// Process file one element at a time
		while (inputDataFile.hasNext()) {
			value = inputDataFile.nextInt();   // Retrieve next value

			// Test current value against max so far.
			// If greater, make it the max value
			if (value > maxVal)
				maxVal = value;
			
			if(value < minVal)
				minVal = value;
			
			int evenTest = value % 2;
			if(evenTest == 0)
				numberOfEvens++;
			

			numVals++;                       // Count this value
		}

		// Write summary
		if (numVals > 0)
		{
			outMsg = "Total values in set: " + numVals + "\n";
			outMsg += "Max value in set: "   + maxVal + "\n";
			outMsg += "Min value in set: "   + minVal + "\n";
			outMsg += "Even numbers in set: "+ numberOfEvens;
		}
		else
			outMsg = "Empty input file";

		// Display output dialog message
		JOptionPane.showMessageDialog( null, outMsg);

		inputDataFile.close();               

		System.exit(0);         // Terminate program
	}
}
