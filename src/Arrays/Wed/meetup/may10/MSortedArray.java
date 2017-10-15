package Arrays.Wed.meetup.may10;
/*
 Given M sorted lists of variable length, print them in sorted order efficiently.

*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MSortedArray {

	public static void main(String args[]){
		int[] arr1 = { 10, 20, 30, 40};
		int[] arr2 = { 15, 25, 35};
		int[] arr3 = { 27, 29, 37, 48, 93};
		int[] arr4 = { 32, 33};

		System.out.println(Arrays.toString(sortArrays(new int[][]{arr1,arr2,arr3,arr4})));
	}

	 static int[] sortArrays(int[][] arr){

		 PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
		int totalLength = 0;
		 for(int[] a : arr){
			 totalLength = totalLength + a.length;
			 pq.offer(new ArrayContainer(a,0));
		}

		int resultIndex = 0;
		int[] resultArray = new int[totalLength];

		 while (!pq.isEmpty()){
			  ArrayContainer  a =  pq.remove();
			  resultArray[resultIndex] = a.arr[a.index];
			 resultIndex++;
			   if(a.index < a.arr.length - 1){
				   pq.offer(new ArrayContainer(a.arr,a.index + 1));
			   }

		 }
		return resultArray;
	}
}


class ArrayContainer implements Comparable<ArrayContainer> {
	int[] arr;
	int index;

	ArrayContainer(int[] arr,int index){
		this.arr = arr;
		this.index = index;
	}

	@Override
	public int compareTo(ArrayContainer o){
		return this.arr[this.index] - o.arr[o.index];
	}
}

