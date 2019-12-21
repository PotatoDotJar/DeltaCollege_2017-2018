
// Delta College - CST 283 - Klingler                          
// This program writes a sales summary to the console based on raw
// sales data read from a file

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SalesSummary {
	// Global constants
	final static int TOTAL_STORES = 4;
	final static int DAYS_IN_WEEK = 5;
	final static String FILENAME = "saledata.txt";

	public static void main(String[] args) {
		int storeData[][] = new int[TOTAL_STORES][DAYS_IN_WEEK];

		buildGrid(storeData); // Load table of store data to array
		summarizeData(storeData); // Create totals and write report

		System.exit(0);
	}

	// This method reads a sequential file of raw store sales data and
	// builds a two-dimensional array containing the data
	// File format: {store_number} {day_of_week (1..5)} {sales}
	public static void buildGrid(int[][] dataTable) {
		int store, day, amount;

		try {
			Scanner inputFileScanner;
			File inputfile;
			inputfile = new File(FILENAME);
			inputFileScanner = new Scanner(inputfile);

			// Read file and populate 2-D array
			int i = 0;
			while (inputFileScanner.hasNext()) {
				store = inputFileScanner.nextInt();
				day = inputFileScanner.nextInt();
				amount = inputFileScanner.nextInt();
				dataTable[store - 1][day - 1] = amount;
			}

			inputFileScanner.close();
		} catch (IOException e) {
			System.out.println("File error");
			System.exit(0);
		}
	}

	// This method creates a summary report for the sales data including totals
	// by store and by day of week
	public static void summarizeData(int[][] dataTable) {
		System.out.println("SALES SUMMARY");
		System.out.println("            MON    TUE    WED    THU    FRI    Total");
		int totalByStore = 0;
		int totalByDay = 0;

		for (int i = 0; i < TOTAL_STORES + 1; i++) {
			if (i < TOTAL_STORES) {
				totalByStore = 0;
				System.out.print("Store " + (i + 1) + " ");
				for (int j = 0; j < DAYS_IN_WEEK; j++) {
					totalByStore += dataTable[i][j];
					System.out.print(String.format("%7d", dataTable[i][j]));
				}
				System.out.print(String.format("%7d", totalByStore));
				System.out.println();
			} else {
				System.out.print("\nTotal    ");
				for (int y = 0; y < DAYS_IN_WEEK; y++) {
					totalByDay = 0;
					for (int x = 0; x < TOTAL_STORES; x++) {
						totalByDay += dataTable[x][y];
					}
					System.out.print(String.format("%7d", totalByDay));
				}
			}
		}

	}
}
