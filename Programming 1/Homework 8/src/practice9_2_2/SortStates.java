package practice9_2_2;

//Delta College - CST 183 - Klingler  
//This program reads the list of U.S. states in chronological order, sorts
//them alphabetically, and writes them to an output file.

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class SortStates
{
	// Constants
	public static final String inputfilename = "statelist.txt";  
	public static final String outputfilename = "sortedstates.txt";  
	public static final int NUM_STATES = 50;

	public static void main(String[] args) throws IOException
	{
		double value;                 // Variable to collect individual input values
		ArrayList<String> data;                // Array of strings for states
		File inputfile;               // Reference for input file

		// Instantiate required objects
		inputfile  = new File(inputfilename);                // Create file input object
		data = new ArrayList<>();                       // Allocate array elements

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
		Scanner inputFileScanner  = new Scanner(inputfile);   

		// File processing loop - Continue while not empty
		// Read file element and store in array
		// Precondition:  File has exactly 50 states
		for (int i = 0; i < NUM_STATES; i++)        
		{
			data.add(inputFileScanner.nextLine());  
		}
		inputFileScanner.close();

		data = sortStringArray(data, NUM_STATES);

		writeArrayToFile(data, NUM_STATES);  // Write sorted array to output

		System.exit(0);         
	}

	// ---------------------------------------------------------------------
	// This method receives an array of String values and
	// sorts them using the collections reverse sort comparator.
	public static ArrayList<String> sortStringArray(ArrayList<String> data, int numElems)
	{

		ArrayList<String> list = data;
		Collections.sort(list, Collections.reverseOrder());
		return list;

	}


	// ---------------------------------------------------------------------
	// This method receives an array of String values
	// sends it to the output file (declared as constant).
	public static void writeArrayToFile(ArrayList<String> data, int numElems) throws IOException
	{
		// Delclare and instantiate output writer object
		PrintWriter outputfileWriter;      
		outputfileWriter = new PrintWriter(outputfilename); 

		// Write data to file
		for (int i = 0; i < numElems; i++)
		{
			outputfileWriter.println(data.get(i));
		}
		outputfileWriter.close();
	}
} 
