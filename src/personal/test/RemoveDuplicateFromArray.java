package personal.test;

import java.util.Arrays;

public class RemoveDuplicateFromArray {
	public static void main(String args[])
	{
		RemoveDuplicateFromArray m = new RemoveDuplicateFromArray();
		int[][] arr = new int [][]{
				{1,1,2,3},
				{1,1,1,1},
				{2,3,4,5},
				{4,2,1,1}
		};


		for(int[] test : arr)
		{
			//System.out.println(Arrays.toString(test));
			m.removeDuplicates(test);
		}


	}


	public int[] removeDuplicates(int[] arrNum) {
		int[] result = new int[arrNum.length];
		Arrays.sort(arrNum);



		int previous = arrNum[0];
		for(int i = 1;i<arrNum.length;i++)
		{
			int ch =arrNum[i];
			if(previous != ch)
			{
				result[i] = ch;
			}
			previous = ch;
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
}
