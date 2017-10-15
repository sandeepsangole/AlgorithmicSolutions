package Arrays;
import java.util.*;

public class MyArray {

	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			} }
		return stack.empty();
	}
	
	public static void main(String args[]) {
		MyArray arr = new MyArray();
		System.out.println(arr.isValid("{()}"));
		System.out.println(arr.largestRectangleArea(new int[]{3,2,5,6,1}));
	}


	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int            i     = 0;
		int            max   = 0;
		while (i < height.length) {

			if (stack.isEmpty() || height[ i ] >= height[ stack.peek() ]) {
				stack.push(i);
				i++;
			} else {
				int p = stack.pop();
				int h = height[ p ];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[ p ];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
		return max;
	}

}
