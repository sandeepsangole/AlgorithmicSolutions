package Stack;

import java.util.*;


public class StackReverse {

	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(2);


		StackReverse obj = new StackReverse();
		System.out.println("Beofre :"+stack);
		obj.reverseStack(stack);
		System.out.println("After :"+stack);


	}

	public void reverseStack(Stack<Integer> stack){
		if(stack.isEmpty()) return ;
		int temp = stack.pop();
		System.out.println(temp);
		reverseStack(stack);
		insertIntoStack(stack,temp);
	}
	public void insertIntoStack(Stack<Integer> stack , int data){
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertIntoStack(stack,data);
		stack.push(temp);


	}

}
