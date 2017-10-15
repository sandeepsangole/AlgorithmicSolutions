package Arrays;


import java.util.*;

public class ValidParenthesisNew{

	public static void main(String args[]){
		ValidParenthesisNew obj = new ValidParenthesisNew();
		System.out.println(obj.countParams(")()())("));
	}

	public int countParams(String str){
		Stack<Character> stack = new Stack<Character>();

		if(str == null || str.length() == 0)
			return 0;

		int count = 0;

		for(int i = 0;i<str.length();i++){

			char c = str.charAt(i);
			if(stack.isEmpty()) {
				stack.push(c);
			}

			switch(c){

				case  ')' : if(stack.peek() == '('){
										count+=2;
										stack.pop();
									} break;
				case  ']': if(stack.peek() == '['){	count+=2; stack.pop(); } break;
				case  '}': if(stack.peek() == '{'){	count+=2; stack.pop();	} break;
				default : stack.push(c);
			}
		}


		return count;
	}
}