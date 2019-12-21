// Delta College - CST 283 - Klingler                  
// This application demonstrates basic linked operations
// Version 3
// add, remove, size, isEmpty, toString
// find, removeAt
// Interators: resetList, atEnd, getNextItem

public class TestList {
	public static void main(String[] args) {
		LinkedList<String> theList = new LinkedList<String>();

		// Insert elements into list
		theList.add("Harry");
		theList.add("Hermione");
		theList.add("Ron");
		theList.add("Voldemort");
		theList.add("Dumbledore");
		theList.add("Ron");

		theList.append("I'm at the end!");

		theList.insertByIndex(1, "I am second!");
		theList.insertByIndex(0, "Hello world!");

		System.out.println("Num of \"Ron\": " + theList.getNumberDuplicated("Ron"));

		// Use iterators to traverse list
		System.out.println("\n\nThe members of the list are:");
		theList.resetList();
		while (!theList.atEnd()) {
			String listItem = theList.getNextItem();
			System.out.println(listItem);
		}
	}
}