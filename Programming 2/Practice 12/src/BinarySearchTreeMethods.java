
// Delta College - CST 283 - Klingler             
// This class is a test driver for a generic binary search tree of integers.
// Features testing:  retrieve

public class BinarySearchTreeMethods {
	public static void main(String[] args) {
		// Instantiate search tree and load from file
		BinarySearchTreev2<String> theTree = new BinarySearchTreev2<String>();

		theTree.add("N");
		theTree.add("G");
		theTree.add("C");
		theTree.add("A");
		theTree.add("D");
		theTree.add("L");
		theTree.add("K");
		theTree.add("S");
		theTree.add("P");
		theTree.add("Q");
		theTree.add("X");
		theTree.add("U");
		theTree.add("Z");

		System.out.println("Max: " + theTree.getMaxValue());
		System.out.println("Min: " + theTree.getMinValue());

		System.out.println("Leaf Nodes: " + theTree.countLeafNodes());
		System.out.println("Non-leaf Nodes: " + theTree.countNonLeaves());

		System.out.println("\n");
		System.exit(0);

	}
}