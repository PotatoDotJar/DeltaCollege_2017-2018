// Delta College - CST 283 - Klingler                  
// A double-ended queue

//insertFront
//deleteFront
//insertBack
//deleteBack

class DeQue<ItemType> {
	// -----------------------------------------------------
	// The Node class is used to implement the linked list.

	private class Node {
		ItemType value;
		Node next;

		Node(ItemType val, Node n) {
			value = val;
			next = n;
		}
	}

	// -----------------------------------------------------

	private Node front;
	private Node rear;

	// -----------------------------------------------------

	// No-arg constructor
	public DeQue() {
		front = null;
		rear = null;
	}

	// Method adds an element to the back
	public void insertBack(ItemType newItem) {

		Node newNode = new Node(newItem, null);

		if (rear == null) {
			rear = newNode;
			front = rear;
		} else {
			rear.next = newNode;
			rear = newNode;
		}

	}

	// Method adds element to front
	public void insertFront(ItemType newItem) {

		Node newNode = new Node(newItem, null);

		if (front == null) {
			front = newNode;
			rear = front;
		} else {
			newNode.next = front;
			front = newNode;
		}

	}

	// The empty method checks to see if the queue is empty.
	// Returns true if and only if queue is empty.
	public boolean isEmpty() {
		return front == null;
	}

	// Method removes element from the front
	// PRE: At least one element exists
	public ItemType removeFront() {

		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}

		Node temp = front;
		front = temp.next;


		return temp.value;

	}

	// Method removes element from the back
	// PRE: At least one element exists
	public ItemType removeBack() {

		if (rear == null || isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}

		ItemType data = rear.value;

		Node temp1 = front;
		Node temp2 = front;

		// Find second to last
		while (temp1 != rear) {
			temp2 = temp1;
			temp1 = temp1.next;
		}

		rear = temp2;
		rear.next = null;

		return data;

	}

	// Returns string representation of items of deque.
	public String toString() {
		String outString = "";

		Node p = front;
		while (p != null) {
			outString += p.value.toString();
			p = p.next;
			if (p != null)
				outString += "\n";
		}
		outString += "\n";
		return outString;
	}
}