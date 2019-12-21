// Delta College - CST 183 - Klingler                          
// This program reads a file of integer data and creates a table of counters
// to summarize the data.

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class SummaryTable 
{
	// Global constants
	final static int TOTAL_PLAYERS = 10;
	final static int SCORE_RANGE = 3;
	final static String FILENAME = "data.txt";

	public static void main(String[] args) 
	{
		int storeData[][] = new int[TOTAL_PLAYERS][SCORE_RANGE];    

		buildGrid(storeData);      // Load table of store data to array
		summarizeData(storeData);  // Create totals and write report

		System.exit(0);
	}

	// This method reads a sequential file of raw store sales data and
	// builds a two-dimensional array containing the data
	// File format:  {store_number}  {day_of_week (1..5)}  {sales}
	public static void buildGrid(int[][] dataTable)
	{
		int player, score;

		try
		{
			Scanner inputFileScanner;
			File inputfile;
			inputfile = new File(FILENAME);  
			inputFileScanner = new Scanner(inputfile);

			// Read file and populate 2-D array
			int i = 0;
			while (inputFileScanner.hasNext())
			{
				player   = inputFileScanner.nextInt();    
				score    = inputFileScanner.nextInt(); 
				
				dataTable[player - 1][score - 1]++;

			}

			inputFileScanner.close();   
		}
		catch (IOException e) 
		{
			System.out.println("File error");
			System.exit(0);
		}
	}

	// This method creates a summary report for the sales data including totals
	// by store and by day of week
	public static void summarizeData(int[][] dataTable)
	{
		System.out.println("PLAYER SUMMARY");
		System.out.println("             1   2   3  ");

		// Loop through array
		int player = 1;
		for(int row = 0; row < dataTable.length; row++) {
			System.out.print("Player: " + player + "   ");
			for(int col = 0; col < dataTable[row].length; col++) {
				System.out.print(dataTable[row][col] + "  ");
			}
			System.out.println();
			player++;
		}







	} 
}
