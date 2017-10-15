package Arrays;

import java.util.PriorityQueue;

public class LargestKth {

	public static void main(String args[]){
		int[] arr ={3,2,1,5,6,4};
		int k = 2;

		LargestKth obj = new LargestKth();
		System.out.println(obj.KthLarges(arr,2));
	}

	public int KthLarges(int[] arr , int k){

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i : arr){
			queue.offer(i);
			if(queue.size() > k){
				queue.poll();
			}

		}

		return queue.peek();

	}
}
