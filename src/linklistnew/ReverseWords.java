package linklistnew;

import java.util.*;

public class ReverseWords {

	//Stack Solution
	public void reverseString(String str){
		Stack<String> stack = new Stack<String>();
		if(str == null || str.length() == 0){
			return;
		}

		String[] strArray = str.split(" ");
		for(String s : strArray){
			stack.push(s);
		}

		while(!stack.isEmpty()){
			System.out.print(stack.pop());
			if(!stack.isEmpty()){
				System.out.print(" ");
			}

		}

	}

	//Pointer solution


	public static void main(String args[]){
		ReverseWords obj = new ReverseWords();
		obj.reverseString("The cat is red");
	}
}
