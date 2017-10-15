package personal.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairNumSumArray {
	public static void main(String args[])
	{
		int[] array = {5,6,2,8,3,9};
		PairNumSumArray sum = new PairNumSumArray();
		sum.findPairs(array);
	}

	void findPairs(int[] array)
	{
		Arrays.sort(array);
		Set<Integer> total = new HashSet<Integer>();

		for(int i=0;i<array.length;i++)
		{
			total.add(array[i]);
		}
		for(int i=0;i<array.length;i++)
		{
			if(array[i] >= array[array.length-1]/2)
				break;

			for (int j=i+1;j<array.length;j++)
			{
				int sum = array[i]+array[j];
				if(sum > array[array.length-1])
					break;
				else
					if(total.contains(sum))
					{
						System.out.print("("+array[i]+","+array[j]+")");
					}
			}
		}

	}
}
