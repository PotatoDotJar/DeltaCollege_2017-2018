
public class Test {

	public static void main(String[] args) {
		BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();

		binarySearchTree.add("Dad");
		binarySearchTree.add("Mom");
		binarySearchTree.add("Sand");
		binarySearchTree.add("Computer");
		binarySearchTree.add("Jesus");
		binarySearchTree.add("Brennan");
		binarySearchTree.add("Apple");
		binarySearchTree.add("Cheese");
		binarySearchTree.add("Quantum Theory");


		binarySearchTree.traverseInOrder();

	}

}
