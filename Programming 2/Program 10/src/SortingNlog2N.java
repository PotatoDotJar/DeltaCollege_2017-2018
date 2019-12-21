// This static class defines a "home" for the following nlog2n sorting algorithms:
// - Heap sort
// - Quick sort

public class SortingNlog2N {
	// ======================================================================
	// HEAP SORT
	// ======================================================================

	// Public launch point for heap sort.
	// 1) Work is done to convert random array int heap
	// 2) Array is sorted by swapping largest element and reheaping
	public static void heapSort(int array[]) {
		
		MainDriver.TOTAL_SWAPS = 0;
		MainDriver.TOTAL_COMPARISONS = 0;
		
		int index;
		int numValues = array.length;

		// Convert the array of values into a heap
		for (index = numValues / 2 - 1; index >= 0; index--)
			reheapDown(array, index, numValues - 1);

		// Sort the array
		for (index = numValues - 1; index >= 1; index--) {
			
			swap(array, 0, index);
			reheapDown(array, 0, index - 1);
		}
	}

	// -----------------------------------------------------------------------
	// This method performs the REHEAP DOWN action to restore
	// a binary tree to a heap after a removal from the root. This is
	// a basic, specific algorithm for integer heaps only.
	// Postcondition: Heap property is restored.
	private static void reheapDown(int elements[], int root, int bottom) {
		int maxChild = 0;
		int rightChild;
		int leftChild;

		leftChild = root * 2 + 1;
		rightChild = root * 2 + 2;
		
		MainDriver.TOTAL_COMPARISONS++;
		if (leftChild <= bottom) {
			
			MainDriver.TOTAL_COMPARISONS++;
			if (leftChild == bottom)
				maxChild = leftChild;
			else if (elements[leftChild] <= elements[rightChild])
				maxChild = rightChild;
			else
				maxChild = leftChild;

			MainDriver.TOTAL_COMPARISONS++;
			if (elements[root] < elements[maxChild]) {
				swap(elements, root, maxChild);
				reheapDown(elements, maxChild, bottom);
			}
		}
	}

	// ======================================================================
	// QUICK SORT
	// ======================================================================

	// Public method to launch quick sort
	public static void quickSort(int array[]) {
		
		MainDriver.TOTAL_SWAPS = 0;
		MainDriver.TOTAL_COMPARISONS = 0;
		
		
		// Initiate sort by passing array and begin/end index
		// to private recursive method.
		doQuickSort(array, 0, array.length - 1);

	}

	// -----------------------------------------------------------------------
	// Recursive action of quicksort algorithm
	private static void doQuickSort(int array[], int start, int end) {
		int pivotPoint;

		MainDriver.TOTAL_COMPARISONS++;
		if (start < end) {
			// Get the pivot point.
			pivotPoint = partition(array, start, end);

			// Sort the first sub list.
			doQuickSort(array, start, pivotPoint - 1);

			// Sort the second sub list.
			doQuickSort(array, pivotPoint + 1, end);
		}
	}

	// -----------------------------------------------------------------------
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

		// Scan the entire list and move any values that
		// are less than the pivot value to the left
		// sub list.
		for (int scan = start + 1; scan <= end; scan++) {
			MainDriver.TOTAL_COMPARISONS++;
			if (array[scan] < pivotValue) {
				endOfLeftList++;
				swap(array, endOfLeftList, scan);
			}

		}

		// Move the pivot value to end of the
		// left sub list.
		swap(array, start, endOfLeftList);

		// Return the subscript of the pivot value.
		return endOfLeftList;
	}

	// ======================================================================
	// A swap function for the 'elements' array.
	private static void swap(int elements[], int fromIndex, int toIndex) {
		MainDriver.TOTAL_SWAPS++;
		int temp = elements[fromIndex];
		elements[fromIndex] = elements[toIndex];
		elements[toIndex] = temp;
	}
	
	
	// Merge Sort
	private static int[] numbers;
	private static int[] helper;
	private static int number;
    
	public static void mergeSort(int[] values) {
		numbers = values;
        number = values.length;
		helper = new int[number];
        mergesort(0, number - 1);
    }

	private static void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
		MainDriver.TOTAL_COMPARISONS++;
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

	private static void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
			MainDriver.TOTAL_SWAPS++;
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
			MainDriver.TOTAL_COMPARISONS++;
            if (helper[i] <= helper[j]) {
				MainDriver.TOTAL_SWAPS++;
                numbers[k] = helper[i];
                i++;
            } else {
				MainDriver.TOTAL_SWAPS++;
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
			MainDriver.TOTAL_COMPARISONS++;
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}