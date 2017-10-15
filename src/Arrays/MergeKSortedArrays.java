package Arrays;

import java.util.*;

public class MergeKSortedArrays {


	public static int[] mergeKSorttedArrays(int[][] arr) {

		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int                           total = 0;

		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayContainer(arr[ i ], 0));
			total = total + arr[ i ].length;
		}

		int m        = 0;
		int result[] = new int[ total ];

		while (!queue.isEmpty()) {
			ArrayContainer ac = queue.poll();
			result[ m++ ] = ac.arr[ ac.index ];
			if (ac.index < ac.arr.length - 1) {
				queue.add(new ArrayContainer(ac.arr, ac.index + 1));
			}
		}
		return result;
	}



	public static void main(String args[]){
		int[] arr1 = new int[]{1,3,5,7};
		int[] arr2 = new int[]{2,4,6,8};
		int[] arr3 = new int[]{0,9,10,11,45,60};

		int[] result = mergeKSorttedArrays(new int[][]{arr1,arr2,arr3});
		System.out.println(Arrays.toString(result));

	}
}

class ArrayContainer implements Comparable<ArrayContainer>{
	int[] arr;
	int index;

	ArrayContainer(int[] arr,int index){
		this.arr = arr;
		this.index = index;
	}

	public int compareTo(ArrayContainer o){
		return this.arr[this.index] - o.arr[o.index];
	}
}

