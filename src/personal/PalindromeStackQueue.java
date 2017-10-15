package personal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeStackQueue {

	Stack st = new Stack();
	Queue qu = new LinkedList();
	
	public static void main(String[] args) {// TODO Auto-generated method stub
		PalindromeStackQueue pal = new PalindromeStackQueue();
		String str = "sandy";
		char[] strarray = str.toCharArray();
		boolean isPalindrome = true;
		
		for(char ch : strarray)
		{
			pal.pushCharacter(ch);
			pal.enQueue(ch);
			
		}
		
		for(int i=0;i<str.length()/2;i++)
		{
			if(pal.popCharacter() != pal.deQueue())
			{
				isPalindrome = false;
				break;
			}
		}
	
			 System.out.println( "The word, " + str + ", is " 
                     + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
		
		
	}
	
	public void pushCharacter(char ch)
	{
		st.push(ch);
		System.out.println(st.toString());
	}
	
	public char popCharacter()
	{
		return (char) st.pop();
	}

	public void enQueue(char ch)
	{
		qu.offer(ch);
		System.out.println("Queue :"+qu.toString());
	}
	
	public char deQueue()
	{
		return (char) qu.remove();
	}
}
