Q3- Write a menu driven program of stack operations using array?

Ans- package class;

public class StackImplementaion {

	private int array[];
	private int capacity;
	private int top;

	public StackImplementaion(int capacity) {
		this.array = new int[capacity];
		this.capacity = capacity;
		this.top = -1;
	}

	public static void main(String[] args) {
		StackImplementaion stackImpl = new StackImplementaion(3);

		stackImpl.push(5);
		stackImpl.push(2);
		stackImpl.push(4);
		for (int i = 0; i < 1; i++) {

			System.out.println("Peek return the top element of the Stack: " + stackImpl.peek());

			System.out.println(
					"Pop also return the top element of the Stack but also remove the element: " + stackImpl.pop());

			System.out.println("Peek after Pop: " + stackImpl.peek());
		}

	}

	public void push(int item) {

		if (isFull()) {
			throw new RuntimeException("Stack is full.");
		}
		array[++top] = item;
	}

	public int pop() {

		if (isEmpty()) {
			throw new RuntimeException("Stack is empty.");
		}

		return array[top--];
	}

	public int peek() {

		if (isEmpty()) {
			throw new RuntimeException("Stack is empty.");
		}
		return array[top];

	}

	private boolean isFull() {

		return top == capacity - 1;
	}

	private boolean isEmpty() {

		return top == -1;
	}
}
