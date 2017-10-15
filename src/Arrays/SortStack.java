package Arrays;

import java.util.Stack;

public class SortStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(9);
		stack.push(3);
		stack.push(0);

		System.out.println(stack);
		sort(stack);
		System.out.println(stack);

	}

	private static void sort(Stack<Integer> stack) {
		if (stack.isEmpty()) return;

		int pop = stack.pop();
		sort(stack);
		insertInOrder(stack, pop);
	}

	private static void insertInOrder(Stack<Integer> stack, int element) {
		if (stack.isEmpty() || stack.peek() < element) {
			stack.push(element);
		} else {
			int pop = stack.pop();
			insertInOrder(stack, element);
			stack.push(pop);
		}
	}

}