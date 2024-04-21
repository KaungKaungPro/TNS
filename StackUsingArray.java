public class StackUsingArray {

	int[] array;
	int topOfStack;

	public void createStack(int size) {
		array = new int[size];
		topOfStack = -1;
	}

	public void push(int data) {
		if (array.length - 1 == topOfStack) {
			System.out.println("Stack Overflow Error!");
			return;
		} else {
			array[topOfStack + 1] = data;
			topOfStack++;
			System.out.println("Inserted!");
		}
	}

	public void pop() {
		if (topOfStack == -1) {
			System.out.println("Stack Underflow Error!");
		} else {
			int tmp = array[topOfStack];
			topOfStack--;
			System.out.println(tmp);
		}
	}

	public void peek() {
		if (topOfStack == -1) {
			System.out.println("Stack is Empty!");
		} else {
			int tmp = array[topOfStack];
			System.out.println(tmp);
		}
	}

	public boolean isEmpty() {
		if (topOfStack == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (array.length - 1 == topOfStack) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteStack() {
		array = null;
	}

	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray();

		// create stack of size 5
		stack.createStack(2);

		// insert 1 to the stack
		stack.push(1);
		stack.push(2);
		

		// pop from the stack
		stack.pop();
		stack.pop();
		
		stack.push(5);
		stack.push(6);

		// check whether stack is empty or not
		System.out.println(stack.isEmpty());

		// peek top element from stack
		stack.peek();

		// isFull method will check whether stack is full or not
		System.out.println(stack.isFull());

	}

}