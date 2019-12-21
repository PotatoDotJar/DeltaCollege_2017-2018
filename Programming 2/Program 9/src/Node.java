/**
 * Class definition of standard data node
 * 
 * @author Richard Nader Jr
 *
 * @param <ItemType>
 */
public class Node<ItemType> {
	ItemType value;
	Node<ItemType> next;

	// Construct node with data and reference to successor
	Node(ItemType val, Node n) {
		value = val;
		next = n;
	}

	// Construct node with data null successor
	Node(ItemType val) {
		this(val, null);
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
