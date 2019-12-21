// Delta College - CST 283 - Klingler                  
// This application demonstrates basic linked list operations
// Version 2

public class TestListR {
	public static void main(String[] args) {
		LinkedListR<String> theList = new LinkedListR<String>();

		theList.add("Harry");
		theList.add("Hermione");
		theList.add("Ron");
		theList.add("Voldemort");
		theList.add("Dumbledore");

		System.out.println("Is \"Ron\" in the list: " + theList.containsRecurse("Ron"));

		// Use iterators to traverse list in order
		System.out.println("The members of the list in order are:");
		theList.resetList();
		while (!theList.atEnd()) {
			String listItem = theList.getNextItem();
			System.out.println(listItem);
		}

		// Demonstrate list in reverSe order
		System.out.println("\nThe members of the list in reverse order are:");
		System.out.println(theList.reverseToString());

		// Count the list elements recursively
		System.out.print("\nNumber of elements in list: ");
		System.out.println(theList.sizeRecurse());
	}
}