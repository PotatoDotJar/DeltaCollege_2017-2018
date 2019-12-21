import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Class to handle data stored in a binary search tree
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader (Edited)
 *
 * @param <ItemType>
 */
// This class implements a binary search tree of String data.
public class BinarySearchTree<ItemType extends Comparable<ItemType>> {
	// This class represents the result of removing a node from a binary tree.
	private class RemovalResult {
		Node node; // Removed node
		Node tree; // Remaining tree

		RemovalResult(Node node, Node tree) {
			this.node = node;
			this.tree = tree;
		}
	}

	// Node class
	public class Node {
		ItemType value;
		Node left, right;

		// Constructor for leaf nodes
		Node(ItemType val) {
			value = val;
			left = null;
			right = null;
		}

		// Constructor for non-leaf nodes
		Node(ItemType val, Node leftChild, Node rightChild) {
			value = val;
			left = leftChild;
			right = rightChild;
		}
	}

	private int size;

	private Node root;

	// ----------------------------------------------------------------------
	// Check if the binary tree is empty.
	public boolean isEmpty() {
		return root == null;
	}

	// ----------------------------------------------------------------------
	/**
	 * The public add method adds a value to the tree by calling a private add
	 * method and passing it the root of the tree.
	 *
	 * @param newItem
	 *            The value to add to the tree.
	 * @return true.
	 */
	public boolean add(ItemType newItem) {
		size++;
		root = add(newItem, root);
		return true;
	}

	/**
	 * The add method adds a value to the search tree.
	 *
	 * @newItem the value to add.
	 * @param bstree
	 *            The root of the binary search tree.
	 * @return The root of the resulting binary search tree.
	 */
	private Node add(ItemType newData, Node bstree) {
		if (bstree == null)
			return new Node(newData);

		// bstree is not null.
		if (newData.compareTo(bstree.value) < 0) {
			// Add newData to the left subtree and replace
			// the current left subtree with the result.
			bstree.left = add(newData, bstree.left);
		} else {
			// Add newData to the right subtree.
			bstree.right = add(newData, bstree.right);
		}
		return bstree;
	}

	// ----------------------------------------------------------------------
	/**
	 * The remove method removes a value from the binary search tree.
	 *
	 * @param removalTarget
	 *            The value to remove.
	 * @returns true if removalTarget was removed, false if removalTarget not found.
	 */
	public boolean remove(ItemType removalTarget) {
		RemovalResult result = remove(root, removalTarget);
		if (result == null)
			return false;
		else {
			root = result.tree;
			return true;
		}
	}

	// This remove method removes a value a from a binary search tree
	// and returns the removed node and the remaining tree wrapped in a
	// RemovalResult object.
	// Parameter bTree is binary search tree (or subtree)
	// @param bTree The binary search tree.
	// @param deleteValue The value to be removed.
	// @return null if deleteValue is not found in bTree.
	private RemovalResult remove(Node bTree, ItemType deleteValue) {
		if (bTree == null)
			return null;

		if (deleteValue.compareTo(bTree.value) < 0) {
			// Remove deleteValue from the left subtree.
			RemovalResult result = remove(bTree.left, deleteValue);
			if (result == null)
				return null;
			bTree.left = result.tree;
			result.tree = bTree;
			return result;
		}

		if (deleteValue.compareTo(bTree.value) > 0) {
			// Remove deleteValue from the right subtree.
			RemovalResult result = remove(bTree.right, deleteValue);
			if (result == null)
				return null;
			bTree.right = result.tree;
			result.tree = bTree;
			return result;
		}

		// deleteValue is in this root node.
		// Is it a leaf?
		if (bTree.right == null && bTree.left == null)
			return new RemovalResult(bTree, null);

		// Does the node have two children?
		if (bTree.right != null && bTree.left != null) {
			// Remove largest node in left subtree and
			// make it the root of the remaining tree.
			RemovalResult remResult = removeLargest(bTree.left);
			Node newRoot = remResult.node;
			newRoot.left = remResult.tree;
			newRoot.right = bTree.right;

			// Prepare the result to be returned.
			bTree.left = null;
			bTree.right = null;
			return new RemovalResult(bTree, newRoot);
		}

		// The node has one child
		Node node = bTree;
		Node tree;
		if (bTree.left != null)
			tree = bTree.left;
		else
			tree = bTree.right;

		node.left = null;
		node.right = null;
		size--;
		return new RemovalResult(node, tree);
	}

	/**
	 * The removeLargest method removes the largest node from a binary search tree.
	 *
	 * @param bTree:
	 *            The binary search tree.
	 * @return The result of removing the largest node.
	 */
	private RemovalResult removeLargest(Node bTree) {
		if (bTree == null)
			return null;

		if (bTree.right == null) {
			// Root is the largest node
			Node tree = bTree.left;
			bTree.left = null;
			size--;
			return new RemovalResult(bTree, tree);
		} else {
			// Remove the largest node from the right subtree.
			RemovalResult remResult = removeLargest(bTree.right);
			bTree.right = remResult.tree;
			remResult.tree = bTree;
			size--;
			return remResult;
		}
	}

	// ---------------------------------------------------------------------
	// The contains method checks to see if a value is in the binary tree.
	// Param searchTarget The value to check for.
	// Return true if searchTarget is in the tree, false otherwise.
	public boolean contains(ItemType searchTarget) {
		// Call the private recursive method.
		return contains(searchTarget, root);
	}

	// The method contains checks whether an item is in a binary search tree.
	// Param searchItem The item to check for.
	// Param bstree The binary tree to look in.
	// Return true if found, false otherwise.
	private boolean contains(ItemType searchItem, Node bstree) {
		if (bstree == null)
			return false;

		if (searchItem.equals(bstree.value))
			return true;
		if (searchItem.compareTo(bstree.value) < 0)
			// Recursively look in left subtree.
			return contains(searchItem, bstree.left);
		else
			// Recursively look in right subtree.
			return contains(searchItem, bstree.right);
	}

	// --------------------------------------------------------------
	// Method searches for existence of target in tree. If matching
	// (i.e. equals method returns true) object from list is returned.
	public ItemType retrieve(ItemType target) {
		// Call the private recursive method.
		return retrieve(target, root);
	}

	// The method contains checks whether an item is in a binary search tree.
	// Param searchItem The item to check for.
	// Param bstree The binary tree to look in.
	// Return node value if found; null otherwise.
	private ItemType retrieve(ItemType searchItem, Node bstree) {
		if (bstree == null)
			return null;

		if (searchItem.equals(bstree.value))
			return bstree.value;
		if (searchItem.compareTo(bstree.value) < 0)
			// Recursively look in left subtree.
			return retrieve(searchItem, bstree.left);
		else
			// Recursively look in right subtree.
			return retrieve(searchItem, bstree.right);
	}

	// ---------------------------------------------------------------------
	// The contains method recursively counts the number of elements in the
	// binary search tree.
	// Return: integer count
	public int size() {
		return count(root);
	}

	int count(Node tree)
	// Post: returns the number of nodes in the tree.
	{
		if (tree == null)
			return 0;
		else
			return count(tree.left) + count(tree.right) + 1;
	}

	// ---------------------------------------------------------------------
	// Method that returns the size int, this is faster
	// than recursively adding each time
	public int getFastSize() {
		return size;
	}

	// ---------------------------------------------------------------------
	// Method that retrieves the search tree as a array list
	public ArrayList<ItemType> toArrayList(ItemType[] a) {
		return new ArrayList<>(Arrays.asList(toArray(a)));
	}

	// ---------------------------------------------------------------------
	// Method that retrieves the search tree as a array
	public ItemType[] toArray(ItemType[] a) {
		Node n = root;
		collect(n, a, 0);
		return a;
	}

	public int collect(Node n, ItemType[] a, int i) {

		if (n.left != null) {
			// If there is a left (smaller) value, we go there first
			i = collect(n.left, a, i);
		}

		// Once we've got all left (smaller) values we can
		// collect the value of out current Node.
		a[i] = n.value;
		i++;

		if (n.right != null) {
			// And if there is a right (larger) value we get it next
			i = collect(n.right, a, i);
		}

		return i;
	}

	ArrayList<Traveler> returnedList;

	// ---------------------------------------------------------------------
	// Method for searching through the binary search tree with a given string
	// Returns matching or containing email Traveler
	public ArrayList<Traveler> search(String email) {

		returnedList = new ArrayList<>();
		searchR(email, root);

		return returnedList;
	}

	private void searchR(String email, Node tree) {

		if (tree != null) {
			if (tree.value instanceof Traveler) {

				Traveler val = (Traveler) tree.value;
				if (val.getEmail().trim().toLowerCase().startsWith(email.trim().toLowerCase())) {
					returnedList.add(val);
				}

				if (val.getEmail().compareTo(email) > 0)
					// Recursively look in left subtree.
					searchR(email, tree.left);
				else
					// Recursively look in right subtree.
					searchR(email, tree.right);
			}
		}
	}

	// ---------------------------------------------------------------------
	// Public method initiating count and returning total to main
	// function call
	public int treeDepth() {
		int depth = getDepth(root) - 1;
		return depth;
	}

	// Private function checking maximum depth below current node
	private int getDepth(Node tree) {
		if (tree == null)
			return 0;
		else {
			// Get depths below current node
			int leftDepth = getDepth(tree.left);
			int rightDepth = getDepth(tree.right);

			// Return max depth of subtrees plus one for "this" node
			if (leftDepth > rightDepth)
				return leftDepth + 1;
			else
				return rightDepth + 1;
		}
	}

	// ----------------------------------------------------------
	// Public launcher for IN-ORDER traversal
	public void traverseInOrder() {
		System.out.println("IN-ORDER");

		inorder(root); // Launch recursion

		System.out.println("\n\n");
	}

	private void inorder(Node btree) {
		if (btree != null) {
			inorder(btree.left);
			System.out.print(btree.value + " ");
			inorder(btree.right);
		}
	}

	// ----------------------------------------------------------
	// Public launcher for PRE-ORDER traversal
	public void traversePreOrder() {
		System.out.println("PRE-ORDER");

		preorder(root); // Launch recursion

		System.out.println("\n\n");
	}

	private void preorder(Node btree) {
		if (btree != null) {
			System.out.print(btree.value + " ");
			preorder(btree.left);
			preorder(btree.right);
		}
	}

	// ----------------------------------------------------------
	// Public launcher for POST-ORDER traversal
	public void traversePostOrder() {
		System.out.println("POST-ORDER");

		postorder(root); // Launch recursion

		System.out.println("\n\n");
	}

	private void postorder(Node btree) {
		if (btree != null) {
			postorder(btree.left);
			postorder(btree.right);
			System.out.print(btree.value + " ");
		}
	}

	// ----------------------------------------------------------
	// Method seeks out the largest value in the tree
	public ItemType getMaxValue() {
		ItemType returnData = null;

		Node right = root.right;
		while (right.right != null) {
			right = right.right;
		}
		returnData = right.value;

		return returnData;
	}

	// Method seeks out the smallest value in the tree
	public ItemType getMinValue() {
		ItemType returnData = null;

		Node left = root.left;
		while (left.left != null) {
			left = left.left;
		}
		returnData = left.value;

		return returnData;
	}

	// Private recursive method for counting leaf nodes
	private int getLeafCount(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}

	// Count number of leaf nodes in tree
	public int countLeafNodes() {
		return getLeafCount(root);
	}

	// Private recursive method for counting non-leaf nodes
	private int getNonLeaves(Node node) {
		if (node == null || (node.left == null && node.right == null))
			return 0;

		return 1 + getNonLeaves(node.left) + getNonLeaves(node.right);
	}

	// Count number of non-leaf nodes in tree
	public int countNonLeaves() {
		return getNonLeaves(root);
	}

	// Method to save tree to data file
	public boolean saveToFile() {
		FileWriter fstream;
		BufferedWriter writer;

		ArrayList<Traveler> data = (ArrayList<Traveler>) toArrayList((ItemType[]) new Traveler[this.size()]);

		// Shuffle list for next read to prevent a stack overflow
		Collections.shuffle(data);

		// Clear the file
		try {
			fstream = new FileWriter(DataImportManager.FILE_PATH, false);
			writer = new BufferedWriter(fstream);

			for (int i = 0; i < data.size(); i++) {
				Traveler traveler = data.get(i);

				String line = traveler.getFirstName() + "," + traveler.getLastName() + "," + traveler.getAddress() + ","
						+ traveler.getCity() + "," + traveler.getState() + "," + traveler.getZipCode() + ","
						+ traveler.getPhone() + "," + traveler.getEmail() + "," + traveler.getRiskLevel();

				if (i == data.size() - 1) {
					writer.write(line);
				} else {
					writer.write(line);
					writer.newLine();
				}

			}

			writer.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error opening file at " + DataImportManager.FILE_PATH);
			return false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error writing to file at " + DataImportManager.FILE_PATH);
			return false;
		}
		return true;
	}
}
