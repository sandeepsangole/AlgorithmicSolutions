package Arrays;

import java.util.*;

public class NumberSubsequence {

	public static void main(String args[]) {
		int                 noLength = 8;
		int                 number   = 12345678;
		LinkedList<Integer> stack    = new LinkedList<Integer>();
		int[] array = new int[noLength-1];
		for (int i = 0; i < noLength; i++) {
			stack.push(number % 10);
			System.out.println(number % 10);
			number = number / 10;
		}

		int count = 0;
		while(stack.isEmpty())
		{
			array[count] = stack.pop();

		}

		int cursor =0;
		
		for(int j =0; j < noLength;j++)
		{
			if(cursor == j)
			{

			}
		}
	}

}
