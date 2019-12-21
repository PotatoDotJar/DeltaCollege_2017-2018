// This example validates a sequence of stack and queue operations

public class StackQueueDemo {
	public static void main(String[] args) {
		StringStack stack = new StringStack(50);
		StringQueue queue = new StringQueue(50);

		// ENTER STACK & QUEUE OPERATIONS HERE
		stack.push("AB"); // Push AB​ onto the stack
		stack.push("XY"); // Push XY​ onto the stack

		queue.enqueue("JK"); // Enqueue JK ​to the queue
		queue.enqueue(stack.pop()); // Pop from the stack and enqueue the value to the queue
		System.out.println(stack.peek()); // Peek at the stack top and write the element to output

		stack.push("JV"); // Push JV​ onto the stack
		stack.push("PQ"); // Push PQ​ onto the stack

		queue.enqueue("SD"); // Enqueue SD​ to the queue
		System.out.println(queue.peek()); // Peek at the queue front and write the element to output
		stack.pop(); // Pop the stack and discard
		System.out.println(stack.peek()); // Peek at the stack top and write the element to output

		stack.push(queue.dequeue()); // Dequeue from the queue and push onto the stack

		queue.enqueue("CV"); // Enqueue CV​ and SA​ to the queue in order
		queue.enqueue("SA");
		stack.pop(); // Pop a value from the stack and discard

		while (!queue.isEmpty()) { // Until empty, dequeue all elements from queue and push onto stack
			stack.push(queue.dequeue());
		}

		while (!stack.isEmpty()) { // Until empty, pop and write the element to output
			System.out.println(stack.pop());
		}

	}
}