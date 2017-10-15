package Arrays;

import java.util.*;

public class ThreeSum{

	public static void main(String args[]){
		ThreeSum obj = new ThreeSum();
		ArrayList<ArrayList<Integer>> result = obj.find3Sum(new int[]{-1,0,1,2,-1,-4});
		System.out.println(result);

	}

	public ArrayList<ArrayList<Integer>> find3Sum(int[] arr){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(arr);

		for(int i = 0;i< arr.length-3;i++){

			if(i ==0 || arr[i] > arr[i-1]){

				int start = i + 1;
				int end = arr.length - 1 ;

				while(start < end){
					if(arr[i] + arr[start]+arr[end] == 0){
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(arr[i]);
						tmp.add(arr[start]);
						tmp.add(arr[end]);
						list.add(tmp);
					}
					if(arr[i] + arr[start]+arr[end] < 0){
						int currentStart = start;
						while(arr[start] == arr[currentStart] && start < end)
							start ++;
					}
					else
					{
						int currentEnd = end;
						while(arr[end] == arr[currentEnd] && start < end)
							end--;
					}
				}
			}

		}

		return list;
	}
}