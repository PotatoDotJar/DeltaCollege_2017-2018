/**
 * Creates a stack for state data.
 */
public class StateStack {

	private State stackArray[];
	private int stackSize;
	private int top;

	// ****************************************************
	// Constructor - Define a stack with designated
	// capacity
	public StateStack(int size) {
		stackArray = new State[size];
		stackSize = size;
		top = 0;
	}

	// ****************************************************
	// Method push pushes the argument onto the stack.
	// PRECONDITION: Stack is NOT FULL
	public void push(State newItem) {
		stackArray[top] = newItem;
		top++;
	}

	// ****************************************************
	// Method pop returns the value at the top
	// of the stack and then removes it.
	// PRECONDITION: Stack is NOT EMPTY
	public State pop() {
		top--;
		return stackArray[top];
	}

	// ****************************************************
	// Method peek returns the value at the top
	// of the stack and then removes it.
	// PRECONDITION: Stack is NOT EMPTY
	public State peek() {
		return stackArray[top - 1];
	}

	// ****************************************************
	// Member function clear "empties" the stack by
	// altering the "top" pointer index
	public void clear() {
		stackArray = new State[1];
		top = 0;
	}

	// ****************************************************
	// Method returns true if the stack is empty, or false
	// otherwise.
	public boolean isEmpty() {
		boolean status;

		if (top <= 0)
			status = true;
		else
			status = false;

		return status;
	}

	public int getSize() {
		return top;
	}

}
