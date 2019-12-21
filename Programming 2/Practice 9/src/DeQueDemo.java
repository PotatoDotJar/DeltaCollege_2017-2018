/**
 * The LinkedQueueDemo class demonstrates the use of the LinkedQueue class.
 */

public class DeQueDemo {
	public static void main(String[] args) {
		DeQue<String> dq = new DeQue<String>();

		dq.insertFront("Delta");
		System.out.println(dq);

		dq.insertBack("SVSU");
		System.out.println(dq);

		dq.insertBack("Northwood");
		dq.insertBack("CMU");
		dq.insertFront("WMU");
		System.out.println(dq);

		System.out.println("Remove: " + dq.removeBack());
		System.out.println(dq);

		System.out.println("Remove: " + dq.removeFront());
		System.out.println(dq);

		System.out.println("Remove: " + dq.removeBack());
		System.out.println(dq);

		System.out.println("Remove: " + dq.removeFront());
		System.out.println(dq);

		System.out.println("Remove: " + dq.removeBack());
		System.out.println(dq);
	}
}