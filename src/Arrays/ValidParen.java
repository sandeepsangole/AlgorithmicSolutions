package Arrays;


import java.util.*;

public class ValidParen {

	public static void main(String args[]) {
		ValidParen obj = new ValidParen();
		System.out.println(obj.isValidParen("{(})"));
	}

	public boolean isValidParen(String paren) {


		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < paren.length(); i++) {

			char ch = paren.charAt(i);

			if (map.keySet().contains(ch)) {
				stack.push(ch);
			} else if (map.values().contains(ch)) {
				if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}