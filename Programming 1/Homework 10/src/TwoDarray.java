// Delta College - CST 183 - Klingler                          
// This program demonstrates basic algorithms operating on a 
// two-dimensional array

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class TwoDarray 
{
	public static void main(String[] args) 
	{
		final int NUM_ROWS = 4;
		final int NUM_COLS = 5;

		int i;
		double sum = 0;
		double maxValue = 0;
		double minValue = Double.MAX_VALUE;
		double sumOfCorners = 0;

		// Declare and initialize array
		double[][] table = {{1.2, 2.3, 3.4, 4.5, 5.6},
				{6.7, 7.8, 8.9, 9.1, 1.3},
				{2.4, 3.5, 4.6, 5.7, 6.8},
				{7.9, 8.1, 9.3, 1.4, 2.5}};

		// Write array to console
		for (i = 0; i < NUM_ROWS; i++) 
		{
			for (int j = 0; j < NUM_COLS; j++) 
				System.out.print(table[i][j] + "  ");
			System.out.println();
		}
		System.out.println("\n");

		// Sum all elements in array
		sum = 0;
		for (i = 0; i < NUM_ROWS; i++) 
			for (int j = 0; j < NUM_COLS; j++) 
				sum = sum + table[i][j];
		System.out.println("Sum of all elements: " + sum);

		// Sum all elements in a given row
		int rowTarget = 2;  
		sum = 0;
		for (int j = 0; j < NUM_COLS; j++) 
			sum = sum + table[rowTarget][j];
		System.out.println("Sum of row " + rowTarget + ": " + sum);


		// Sum all elements in a given column
		int columnTarget = 1;  
		sum = 0;
		for (i = 0; i < NUM_ROWS; i++) 
			sum = sum + table[i][columnTarget];
		System.out.println("Sum of row " + rowTarget + ": " + sum);
		
		// Find min and max values in array
		for (i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				if(table[i][j] > maxValue)
					maxValue = table[i][j];
				if(table[i][j] < minValue)
					minValue = table[i][j];
			}
		}
		System.out.println("Max value in array: " + maxValue);
		System.out.println("Min value in array: " + minValue);
		
		// Find sum of 4 "corners"
		sumOfCorners = table[0][0] + 
				table[NUM_ROWS - 1][0] + 
				table[0][NUM_COLS - 1] + 
				table[NUM_ROWS - 1][NUM_COLS - 1];
		System.out.println("Sum of 4 \"corners\": " + sumOfCorners);
		
	}
}