package practice9_1_2;

//Delta College - CST 183 - Klingler  
//This program reads a sequence of values from a file and 
//stores them in an array.  It then processes the array to
//calculate the average of the numbers

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class SimpleStatsMethod2
{
	// Constants
	public static final String datafilename = "statdata.txt";  
	public static final int ARRAY_SIZE = 5000;

	public static void main(String[] args) throws IOException
	{
		int sum   = 0;        // Accumulator - initialized to zero
		int value;            // Variable to collect individual input values
		double average = 0;   // Stores final output
		int max, min;         // To store max and min values
		int median = 0;		  // To store median value
		String outputMessage; // String to be displayed at end
		int data[];           // Reference for data array
		File inputfile;       // Reference for input file
		int i;                // Array index marker
		int numElems = 0;     // Number of actual data elements stored in array

		// Instantiate required objects
		inputfile = new File(datafilename);  // Create file input object
		data = new int[ARRAY_SIZE];

		// Check for file existence.  If not found, display error and crash
		if (!inputfile.exists())
		{   
			JOptionPane.showMessageDialog( null, 
					"File was not found", 
					"File Error", 
					JOptionPane.ERROR_MESSAGE );
			System.exit(0);
		}

		// Asserting file found, instantiate scanner object for input
		Scanner inputAveFile = new Scanner(inputfile);  

		// File processing loop - Continue while not empty
		// Read file element and store in array
		i = 0;
		while (inputAveFile.hasNext())
		{
			data[i] = inputAveFile.nextInt();   // Capture file value
			i++;                                // Advance array marker
		}
		numElems = i;

		// Initiate output message
		outputMessage = "Statistical Summary" +  "\n";

		// Check for non-empty file.  If OK, perform calculations and set up output. 
		if (numElems > 0)
		{
			// Peform method calls to determine statistical parameters
			sum     = calcSum(data,numElems);       
			average = calcAverage(data,numElems);   
			max     = getMax(data,numElems);
			min     = getMin(data,numElems);
			median  = getMedian(data, numElems);

			// Forulate output message string for good results
			outputMessage += "Sum of all data: " + sum + "\n";
			outputMessage += "Max value:       " + max + "\n";
			outputMessage += "Min value:       " + min + "\n";
			outputMessage += "Median value:    " + median + "\n";
			outputMessage += String.format("Average of numbers is: %5.1f",average);
		}
		else  // Otherwise, assign output message to designate an error
			outputMessage = "Empty file - Not data processed";

		// Show final output dialog
		JOptionPane.showMessageDialog( null, outputMessage);

		inputAveFile.close();   // Close file

		System.exit(0);         // Terminate program
	}

	// ---------------------------------------------------------------------
	// This method receives an array of integers and calculates the average
	// Parameter numElems defines precise number of valid data elements in array
	// PRECONDITION: Parameter numElems > 0   
	public static int calcSum(int dataList[], int numElems)
	{
		int sum = 0;
		for (int i = 0; i < numElems; i++)
			sum += dataList[i];
		return sum;
	}

	// ---------------------------------------------------------------------
	// This method receives an array of integers and calculates the average
	// The return value is a floating point value
	// Parameter dataSize defines precise number of valid data elements in array
	// PRECONDITION: Parameter dataSize > 0
	public static double calcAverage(int array[], int dataSize)
	{
		int total = calcSum(array,dataSize);
		double average = (double)total / (double)dataSize;
		return average;
	}

	// ---------------------------------------------------------------------
	// This method receives an array of integers and returns the maximum
	// value in the array
	// Parameter numElems defines precise number of valid data elements in array
	// PRECONDITION: Parameter numElems > 0
	public static int getMax(int numbers[], int numElems)
	{
		int highest = numbers[0];
		for (int i = 1; i < numElems; i++)
		{
			if (numbers[i] > highest)
				highest = numbers[i];
		}
		return highest;
	}

	// ---------------------------------------------------------------------
	// This method receives an array of integers and returns the minimum
	// value in the array
	// Parameter numElems defines precise number of valid data elements in array
	// PRECONDITION: Parameter numElems > 0
	public static int getMin(int numbers[], int numElems)
	{
		int lowest = numbers[0];
		for (int i = 1; i < numElems; i++)
		{
			if (numbers[i] < lowest)
				lowest = numbers[i];
		}
		return lowest;
	}

	// ---------------------------------------------------------------------
	// This method receives an array of integers and returns the median
	// value in the array
	// Parameter numElems defines precise number of valid data elements in array
	// PRECONDITION: Parameter numElems > 0
	public static int getMedian(int numbers[], int numElems)
	{
		int[] array = numbers;
		sortArray(array, numElems);
		
		return array[numElems / 2];

	}

	// ---------------------------------------------------------------------
	// This method receives an array of integers and sorts the array
	// Parameter numElems defines precise number of valid data elements in array
	// PRECONDITION: Parameter numElems > 0
	public static void sortArray(int numbers[], int numElems)
	{
		int startScan, index, minIndex, minValue;

		for(startScan = 0; startScan < (numElems-1); startScan++) {
			minIndex = startScan;
			minValue = numbers[startScan];
			for(index = startScan + 1; index < numElems; index++) {
				if(numbers[index] < minValue) {
					minValue = numbers[index];
					minIndex = index;
				}
			}

			numbers[minIndex] = numbers[startScan];
			numbers[startScan] = minValue;
		}

	}




}






