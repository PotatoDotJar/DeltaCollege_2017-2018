// Delta College - CST 283 - Klingler 
// A demonstration of the QuickSort algorithm.

public class QuickSortDemo {
	public static void main(String[] args) {
		// Declare array
		int[] array = { 15, 34, 99, 42, 11, 41, 66, 23, 55, 93, 48 };

		// Display before
		System.out.println("Original order: ");
		for (int element : array)
			System.out.print(element + " ");
		System.out.println("\n");

		// Sort the array
		quickSort(array);

		// Display after
		System.out.println("\nSorted order: ");
		for (int element : array)
			System.out.print(element + " ");

		System.out.println("\n\n");

	}

	// ======================================================================
	// Public method to launch quick sort
	public static void quickSort(int array[]) {
		// Initiate sort by passing array and begin/end index
		// to private recursive method.
		doQuickSort(array, 0, array.length - 1);

	}

	// ======================================================================
	// Recursive action of quicksort algorithm
	private static void doQuickSort(int array[], int start, int end) {
		int pivotPoint;

		if (start < end) {
			// Get the pivot point.
			pivotPoint = partition(array, start, end);

			// Sort the first sub list.
			doQuickSort(array, start, pivotPoint - 1);

			// Sort the second sub list.
			doQuickSort(array, pivotPoint + 1, end);
		}
	}

	// ======================================================================
	/*
	 * The partiton method selects a pivot value in an array and arranges the array
	 * into two sub lists. All the values less than the pivot will be stored in the
	 * left sub list and all the values greater than or equal to the pivot will be
	 * stored in the right sub list.
	 * 
	 * @param array The array to partition.
	 * 
	 * @param start The starting subscript of the area to partition.
	 * 
	 * @param end The ending subscript of the area to partition.
	 * 
	 * @return The subscript of the pivot value.
	 */
	private static int partition(int array[], int start, int end) {
		int pivotValue; // To hold the pivot value
		int endOfLeftList; // Last element in the left sub list.
		int mid; // To hold the mid-point subscript

		// Find the subscript of the middle element.
		// This will be our pivot value.
		mid = (start + end) / 2;

		// Swap the middle element with the first element.
		// This moves the pivot value to the start of
		// the list.
		swap(array, start, mid);

		// Save the pivot value for comparisons.
		pivotValue = array[start];

		// For now, the end of the left sub list is
		// the first element.
		endOfLeftList = start;

		System.out.println(writeArray(array, start, end));

		// Scan the entire list and move any values that
		// are less than the pivot value to the left
		// sub list.
		for (int scan = start + 1; scan <= end; scan++) {
			if (array[scan] < pivotValue) {
				endOfLeftList++;
				swap(array, endOfLeftList, scan);
			}
			System.out.println(writeArray(array, start, end));
		}

		// Move the pivot value to end of the
		// left sub list.
		swap(array, start, endOfLeftList);

		System.out.println(writeArray(array, start, end));

		// Return the subscript of the pivot value.
		return endOfLeftList;
	}

	// ======================================================================
	// A swap function for the 'elements' array.
	private static void swap(int elements[], int fromIndex, int toIndex) {
		int temp = elements[fromIndex];
		elements[fromIndex] = elements[toIndex];
		elements[toIndex] = temp;
	}

	// ======================================================================
	// A swap function for the 'elements' array.
	private static String writeArray(int array[], int start, int end) {
		String output = "";
		for (int i = start; i <= end; i++)
			output += Integer.toString(array[i]) + " ";
		return output;
	}

}