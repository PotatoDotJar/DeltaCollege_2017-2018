// Delta College - CST 283 - Klingler             
// This class is a test driver for a binary search tree.
// Features testing:  insert, delete, traversal

public class BinarySearchTreeDemo1 {
	public static void main(String[] args) {
		BinarySearchTree binTree = new BinarySearchTree();

		// binTree.add("J");
		// binTree.add("E");
		// binTree.add("A");
		// binTree.add("H");
		// binTree.add("T");
		// binTree.add("M");
		// binTree.add("Y");

		binTree.add("H");
		binTree.add("C");
		binTree.add("R");
		binTree.add("A");
		binTree.add("S");
		binTree.add("Q");
		binTree.add("B");
		binTree.add("F");
		binTree.add("Z");
		binTree.add("M");
		binTree.add("D");
		binTree.add("X");

		binTree.add("G");
		binTree.remove("Q");
		binTree.add("I");
		binTree.add("Y");
		binTree.remove("R");
		binTree.remove("H");
		binTree.remove("C");
		binTree.add("H");

		binTree.traverseInOrder();
		binTree.traversePreOrder();
		binTree.traversePostOrder();

		// binTree.remove("J");
		// binTree.remove("E");
		//
		// binTree.traverseInOrder();
		// binTree.traversePreOrder();
		// binTree.traversePostOrder();
	}
}