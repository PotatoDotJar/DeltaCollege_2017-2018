// This program performs an experiment to demonstrate the relative
// efficiency of the binary search versus the linear search.  The
// number of comparisons (if statements) performed for each search
// is counted as a measure of the "work" performed

// In this experiment, the list is sorted in a descending order.

import java.util.Random;

import javax.swing.JOptionPane;

public class BinSearchBack {
	public static void main(String[] args) {
		final int NUM_TESTS = 5;

		int list[] = { 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77,
				76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51,
				50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25,
				24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int target, testReturn;
		String outMessage = "";

		// Ready random number generator object
		Random randomNumbers = new Random();

		// Get search value
		target = randomNumbers.nextInt(list.length);
		outMessage += "Search target: " + target + "\n";

		// Perform linear search
		testReturn = sequentialSearch(list, target, list.length);
		outMessage += "LinSearch - Found at position: " + testReturn + "\n";

		// Perform binary search
		testReturn = binarySearch(list, target, list.length);
		outMessage += "BinSearch - Found at position: " + testReturn + "\n";

		JOptionPane.showMessageDialog(null, outMessage);

		System.exit(0);
	}

	// *****************************************************************
	// The searchList method performs a linear search on an *
	// integer array. The array list, which has a maximum of numElems *
	// elements, is searched for the number stored in value. If the *
	// number is found, its array subscript is returned. Otherwise, *
	// -1 is returned indicating the value was not in the array. *
	// *****************************************************************
	public static int sequentialSearch(int[] array, int value, int numElems) {
		int index; // Loop control variable
		int element; // Position the value is found at
		boolean found; // Flag indicating search results

		index = (numElems - 1); // Start search at index zero
		element = -1; // Set to default values;
		found = false; // assuming not found

		// Begin search of array from index zero forward.
		// Search while not found and not yet at end of list
		while (!found && index > 0) {
			if (array[index] == value) // If found
			{
				found = true; // reset to terminate search
				element = index; // retain index of target value
			}
			index--; // Otherwise, advance to next element
		}

		return element;
	}

	// ***************************************************************
	// This method performs a binary search on an integer array. *
	// The array is searched for the number stored in value. If the *
	// number is found, its array subscript is returned. Otherwise, *
	// -1 is returned indicating the value was not in the array. *
	// PRE: Array is in ascending order. *
	// ***************************************************************
	public static int binarySearch(int array[], int value, int numElems) {
		int first = numElems - 1, // Index of first array element
				last = 0, // Index of last good array element
				middle, // Mid point of search
				position = -1; // Position of search value
		boolean found = false; // To indicate if found or not

		while (!found && first >= last) {
			middle = (first + last) / 2; // Calculate mid point
			if (array[middle] == value) // If value is found at mid
			{
				found = true;
				position = middle;
			} else if (array[middle] > value) // If value is in lower half
				last = middle - 1;
			else
				first = middle + 1; // If value is in upper half
		}
		return position;
	}

}