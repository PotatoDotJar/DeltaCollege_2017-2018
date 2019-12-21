// Delta College - CST 283 - Klingler & Gaddis Text                  
// This class implements an unordered singly-linked list of objects.
// Version 3
// add, remove, size, isEmpty
// append, addAt, removeAt
// Iterators:  resetList, atEnd, getNextItem

class LinkedList<ItemType> {

	private Node<ItemType> first; // list head
	private Node<ItemType> last; // last element in list

	private Node<ItemType> currentPos; // Current position for iterator action

	// Adding this variable to keep track of how many items are in the list at all
	// times greatly
	// reduces the amount of time it takes to get the size of the list
	private int size; // Variable used to keep track of the size of the list

	// --------------------------------------------------------------
	// No-arg constructor for linked list. Declare empty; null out pointers
	public LinkedList() {
		first = null;
		last = null;
	}

	// --------------------------------------------------------------
	// Observer to determine if list empty
	public boolean isEmpty() {
		return first == null;
	}

	// --------------------------------------------------------------
	// Get current (integer) length of list
	public int countSize() {
		int count = 0;
		Node<ItemType> currNode = first;
		while (currNode != null) {
			count++; // Increment counter
			currNode = currNode.next; // Advance to next node
		}
		size = count;
		return count;
	}

	// --------------------------------------------------------------
	// Method adds an element to the front of the list
	public void add(ItemType newElementData) {
		if (isEmpty()) // If list empty, simply add new element
		{
			first = new Node<ItemType>(newElementData);
			last = first;
		} else // Otherwise, add parameter element to front of list
		{
			Node<ItemType> newNode = new Node<ItemType>(newElementData);
			newNode.next = first;
			first = newNode;
		}
		size++;
	}

	// --------------------------------------------------------------
	// Method adds an element to the front of the index in the list
	public boolean insertByIndex(int index, ItemType newElementData) {
		if (index < countSize() && index >= 0) {

			// Index is at beginning of list
			if (index == 0) {
				add(newElementData);
				return true;
			}

			// Index is at end of list
			else if (index == countSize() - 1) {
				append(newElementData);
				return true;

				// Index is in middle
			} else {
				Node<ItemType> i = first;
				Node<ItemType> prev = null;
				for (int v = 0; v <= index - 1; v++) {
					if (v == index - 1) {
						prev = i;
					}

					i = i.next;
				}

				Node<ItemType> shiftForward = i;

				Node<ItemType> newNode = new Node<ItemType>(newElementData);
				prev.next = newNode;
				newNode.next = shiftForward;
				return true;
			}

		}
		return false;
	}

	// --------------------------------------------------------------
	// Method finds number of occurrences in the linked list of specified ItemType
	public int getNumberDuplicated(ItemType item) {
		Node<ItemType> i = first;
		int count = 0;
		for (int x = 0; x < countSize(); x++) {
			if (i.value.equals(item)) {
				count++;
			}
			i = i.next;
		}

		return count;
	}

	// --------------------------------------------------------------
	// Method adds an element to the END of the list
	public void append(ItemType newElementData) {
		if (isEmpty()) // If list empty, simply add new element
		{
			first = new Node<ItemType>(newElementData);
			last = first;
		} else // Otherwise, add parameter element to front of list
		{
			Node<ItemType> newNode = new Node<ItemType>(newElementData);

			last.next = newNode;
			last = newNode;

		}

		size++;
	}

	// --------------------------------------------------------------
	// Method removes an element by searching for and matching the value
	public boolean remove(ItemType element) {
		// Special case: empty list - do nothing
		if (isEmpty())
			return false;

		// Special case: element matched for deletion is first element
		if (element.equals(first.value)) {
			first = first.next;
			if (first == null)
				last = null;
			return true;
		}

		// Find the predecessor of the element to remove
		Node<ItemType> pred = first;
		while (pred.next != null && !pred.next.value.equals(element)) {
			pred = pred.next;
		}

		// If not found return false
		if (pred.next == null)
			return false;

		// Otherwise, element found and pred.next.value is element
		pred.next = pred.next.next; // Bypass element to delete it

		// Special case: check if pred is now last
		if (pred.next == null)
			last = pred;

		return true;
	}

	// --------------------------------------------------------------
	// Method searches for existence of target in list using linear
	// search. If matching (i.e. equals method returns true) object
	// in list overwrites parameter hence returning entire list object
	// by reference.
	// Param: target. Search target.
	// Return: boolean. Found target or did not find target
	public boolean contains(ItemType target) {
		boolean moreToSearch;
		Node<ItemType> nodePtr;

		nodePtr = first; // Start search from head of list
		boolean found = false; // Assume value not found
		moreToSearch = (nodePtr != null);

		while (moreToSearch && !found) {
			if (target.equals(nodePtr.value)) {
				found = true;
			} else {
				nodePtr = nodePtr.next;
				moreToSearch = (nodePtr != null);
			}
		}
		return found;
	}

	// --------------------------------------------------------------
	// Method removes the element at an index. Returns object being
	// removed
	// PRE: index >= 0 && index < size
	public ItemType removeAt(int index) {
		// Special case: remove element at front of list
		ItemType element; // The element to return
		if (index == 0) {
			// Adjust reference pointers at front
			element = first.value;
			first = first.next;
			if (first == null)
				last = null;
		} else {
			// To remove an element other than the first, find the predecessor
			// of the element to be removed by marching variable pred
			// forward index - 1 times
			Node<ItemType> pred = first;
			for (int k = 1; k <= index - 1; k++)
				pred = pred.next;

			element = pred.next.value; // Capture return value

			pred.next = pred.next.next; // Bypass element to be removed

			// Special case: check if pred is now last; adjust if necessary
			if (pred.next == null)
				last = pred;
		}
		return element;
	}

	// --------------------------------------------------------------
	// Observer function to return current list length
	public void resetList() {
		currentPos = first;
	}

	// --------------------------------------------------------------
	// Function: Gets the next element in list as
	// referenced by currPtr
	// Pre: Current position is defined.
	// Post: Current position is updated to next position.
	// item is a copy of element at current position.
	public ItemType getNextItem() {
		ItemType item;

		if (currentPos == null)
			currentPos = first; // Wrap if position is at end

		item = currentPos.value; // Get item at current position
		currentPos = currentPos.next; // Advance to next position

		return item; // Return item
	}

	// --------------------------------------------------------------
	// Observer function to determine if current
	// is the end of the list
	public boolean atEnd() {
		if (currentPos == null)
			return true;
		else
			return false;
	}

	// --------------------------------------------------------------
	// Function to return first element in the list
	public Node<ItemType> getFirst() {
		return first;
	}

	// --------------------------------------------------------------
	// Function to return first element in the list
	public int getCount() {
		return size;
	}

	// --------------------------------------------------------------
	// The toString method computes the string representation of the list.
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();

		// Use currPos to walk down the linked list
		Node<ItemType> currPos = first;
		while (currPos != null) {
			strBuilder.append(currPos.value + "\n");
			currPos = currPos.next;
		}
		return strBuilder.toString();
	}
}