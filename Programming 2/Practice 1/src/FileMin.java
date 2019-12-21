
// Delta College - CST 183 - Klingler                          
// This program reads a file of data containing three integers per line.  It
// determines the minimum value of the pair and accumulates it to ultimately
// calculate the average of the minimum line values.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileMin {
	public static final String dataFilename = "mindata3.txt"; // Filename constant

	public static void main(String[] args) throws IOException {
		int sum = 0; // Accumulator - initialized to zero
		int count = 0; // Counter - initialized to zero
		int value1, value2, value3; // Variables to collect individual input values
		double average = 0; // Stores final output
		String outputMessage; // String to be displayed at end

		File inputfile = new File(dataFilename); // Create file input object

		// Check for file existence. If not found, display error and crash
		if (!inputfile.exists()) {
			JOptionPane.showMessageDialog(null, "File was not found", "File Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		// Asserting file found, instantiate scanner object for input
		Scanner inputFileScanner = new Scanner(inputfile);

		// File processing loop - Continue while not empty
		while (inputFileScanner.hasNext()) {
			value1 = inputFileScanner.nextInt(); // Read three data tokens
			value2 = inputFileScanner.nextInt();
			value3 = inputFileScanner.nextInt();

			if (value1 < value2) // Accumulate minimum value from 3 values using mindata3.txt
				if (value1 < value3)
					sum += value1;
				else
					sum += value3;
			else if (value2 < value3)
				sum += value2;
			else
				sum += value3;
			count++; // Increment counter
		}

		// Check for non-empty file. If OK, perform calculations and set up output.
		if (count > 0) {
			average = (double) sum / (double) count; // Determine average
			outputMessage = String.format("Average of minimum numbers is: %5.1f", average);
		} else
			outputMessage = "Empty file - Not data processed";

		// Show final output dialog
		JOptionPane.showMessageDialog(null, outputMessage);

		inputFileScanner.close(); // Close file

		System.exit(0); // Terminate program
	}
}