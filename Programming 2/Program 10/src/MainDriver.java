/**
 * Main driver class for the experiment
 * 
 * @author Richard Nader
 */
public class MainDriver {

	public static int TOTAL_SWAPS = 0;
	public static int TOTAL_COMPARISONS = 0;

	public static long startNanoTime = 0;
	public static long endNanoTime = 0;


	// Main constructor
	public MainDriver() {
		sortN2();
		sortNlog2N();
	}

	// Run N2 sorting
	private void sortN2() {
		System.out.println("\n---------------------- Sorting N2 Algorithms ----------------------");
		// ------------- Inverse Data Sorting -------------
		// Bubble sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.bubbleSort(new FileImporter("inverse.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Bubble sort on inverse data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");
		
		clearTime();

		// Section Sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.selectionSort(new FileImporter("inverse.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out
				.println("Section sort on inverse data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Insertion Sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.insertionSort(new FileImporter("inverse.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println(
				"Insertion sort on inverse data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// ------------- Random Data Sorting -------------
		// Bubble sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.bubbleSort(new FileImporter("random.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Bubble sort on random data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Section Sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.selectionSort(new FileImporter("random.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Section sort on random data completed in " + getTimeTaken() + "ms with "
				+ TOTAL_COMPARISONS + " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Insertion Sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.insertionSort(new FileImporter("random.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Insertion sort on random data completed in " + getTimeTaken() + "ms with "
				+ TOTAL_COMPARISONS + " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// ------------- Almost Data Sorting -------------
		// Bubble sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.bubbleSort(new FileImporter("almost.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Bubble sort on almost data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Section Sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.selectionSort(new FileImporter("almost.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Section sort on almost data completed in " + getTimeTaken() + "ms with "
				+ TOTAL_COMPARISONS + " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Insertion Sort Inverse
		startNanoTime = System.nanoTime();
		SortingN2.insertionSort(new FileImporter("almost.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Insertion sort on almost data completed in " + getTimeTaken() + "ms with "
				+ TOTAL_COMPARISONS + " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();
	}

	// Run Nlog2N sorting
	private void sortNlog2N() {
		System.out.println("\n---------------------- Sorting Nlog2N Algorithms ----------------------");

		// ------------- Inverse Data Sorting -------------
		// Heap sort Inverse
		startNanoTime = System.nanoTime();
		SortingNlog2N.heapSort(new FileImporter("inverse.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Heap sort on inverse data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Quick Sort Inverse
		startNanoTime = System.nanoTime();
		SortingNlog2N.quickSort(new FileImporter("inverse.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Quick sort on inverse data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Merge Sort Inverse
		startNanoTime = System.nanoTime();
		SortingNlog2N.mergeSort(new FileImporter("inverse.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Merge sort on inverse data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();


		// ------------- Random Data Sorting -------------
		// Heap sort Random
		startNanoTime = System.nanoTime();
		SortingNlog2N.heapSort(new FileImporter("random.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Heap sort on random data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Quick Sort Random
		startNanoTime = System.nanoTime();
		SortingNlog2N.quickSort(new FileImporter("random.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Quick sort on random data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Merge Sort Random
		startNanoTime = System.nanoTime();
		SortingNlog2N.mergeSort(new FileImporter("random.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Merge sort on random data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();


		// ------------- Almost Data Sorting -------------
		// Heap sort Almost
		startNanoTime = System.nanoTime();
		SortingNlog2N.heapSort(new FileImporter("almost.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Heap sort on almost data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Quick Sort Almost
		startNanoTime = System.nanoTime();
		SortingNlog2N.quickSort(new FileImporter("almost.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Quick sort on almost data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.");

		clearTime();

		// Merge Sort Almost
		startNanoTime = System.nanoTime();
		SortingNlog2N.mergeSort(new FileImporter("almost.txt").getDataArray());
		endNanoTime = System.nanoTime();
		System.out.println("Merge sort on almost data completed in " + getTimeTaken() + "ms with " + TOTAL_COMPARISONS
				+ " comparisons and " + TOTAL_SWAPS + " swaps.\n");

		clearTime();
	}


	public static void main(String[] args) {
		new MainDriver();
	}

	private static int getTotalSwaps() {
		return TOTAL_SWAPS;
	}

	private static int getTotalComparisons() {
		return TOTAL_COMPARISONS;
	}

	private static double getTimeTaken() {
		return ((double) endNanoTime - (double) startNanoTime) / 1000000.0D;
	}

	private static void clearTime() {
		startNanoTime = 0;
		endNanoTime = 0;
	}

}
