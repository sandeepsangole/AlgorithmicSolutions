package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ArrayPQ {

	public static void main(String args[]){
		ArrayPQ obj = new ArrayPQ();
		int[] result = obj.getSubArrray(new int[]{7,6,3,2,8,9,15,12,1},5);
		System.out.println(Arrays.toString(result));
	}
	public int[] getSubArrray(int[] a, int k)
	{
		int[] b = new int[k];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for(int i = 0;i<a.length ;i++) {
			queue.add(a[i]);
		}

		for(int i = 0;i < b.length;i++){
			b[i] = queue.poll();
		}

		return b;

	}
}
