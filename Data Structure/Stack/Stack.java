import java.util.LinkedList;

/**
 * Implement stack based on LinkedList
 * @author Zhengkai Zhang
 */

public class Stack {
	private LinkedList<Integer> stack;
	private int size;
	public Stack(int input_size) {
		stack = new LinkedList<Integer>();
		size = input_size;
	}

	public boolean push(int input) {
		if (stack.size() == size) {
			return false;
		}
		stack.addFirst(input);
		return true;
	}

	public int pop() {
		if (stack.size() == 0) {
			throw new NullPointerException("Stack is Empty");
		}
		return stack.removeFirst();
	}

	public int poll() {
		if (stack.size() == 0) {
			throw new NullPointerException("Stack is empty");
		}

		return stack.getFirst();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Integer num : stack) {
			sb.append(num);
			sb.append(" ");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Stack stack = new Stack(2);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
	}

}
