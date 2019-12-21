
// Delta College - CST 283 - Klingler     
// This program tests the equivalence method for the ordered list class.

public class OrderListDriver {
	public static void main(String args[]) {

		OrderList list1 = new OrderList("info1.txt", OrderList.SortState.ASCENDING);
		OrderList list2 = new OrderList("info2.txt", OrderList.SortState.ASCENDING);
		OrderList list3 = new OrderList("info3.txt", OrderList.SortState.ASCENDING);

		// Writes lists
		System.out.println("List 1\n" + list1.toString() + "\n");
		System.out.println("List 2\n" + list2.toString() + "\n");
		System.out.println("List 3\n" + list3.toString() + "\n");

		// Compare lists
		if (list1.equals(list2))
			System.out.println("List1 == List2\n");
		else
			System.out.println("List1 != List2\n");

		if (list1.equals(list3))
			System.out.println("List1 == List3\n");
		else
			System.out.println("List1 != List3\n");

		if (list2.equals(list3))
			System.out.println("List2 == List3\n");
		else
			System.out.println("List2 != List3\n");

		System.exit(0);
	}
}