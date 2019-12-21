
// Delta College - CST 283 - Klingler             
// This class is a test driver for a simple priority queue of integers.

public class TestPQ {
	private static PQtype<Integer> thePQ;

	public static void main(String[] args) {
		thePQ = new PQtype<Integer>();

		// Complete test plan
		thePQ.enqueue(7);
		thePQ.enqueue(17);
		thePQ.enqueue(2);
		thePQ.enqueue(5);
		thePQ.enqueue(22);
		thePQ.enqueue(19);
		thePQ.enqueue(6);
		thePQ.enqueue(11);
		thePQ.enqueue(13);

		System.out.println("AFTER ENQUEUE SET 1");
		System.out.println(thePQ.toString()); // Write entire queue

		System.out.println("DEQUEUE");

		System.out.println(thePQ.dequeue());

		thePQ.enqueue(15);
		thePQ.enqueue(8);

		System.out.println(thePQ.dequeue());
		System.out.println(thePQ.dequeue());

		thePQ.enqueue(24);
		thePQ.enqueue(14);

		System.out.println("\n\nAFTER ENQUEUE SET 2");
		System.out.println(thePQ.toString()); // Write entire queue

	}

}
