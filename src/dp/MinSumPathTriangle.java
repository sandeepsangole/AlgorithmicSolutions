package dp;

import java.util.ArrayList;
import java.util.List;

public class MinSumPathTriangle {

	public static void main(String args[]){
		int[] arr = new int[]{2};
		int[] arr1 = new int[]{3,4};
		int[] arr2 = new int[]{6,5,7};
		int[] arr3 = new int[]{4,1,8,3};

		List<int[]> triagle = new ArrayList<int[]>();
		triagle.add(arr);
		triagle.add(arr1);
		triagle.add(arr2);
		triagle.add(arr3);

		System.out.println(triangleMinSumPath2(triagle));


	}

	/*
				2
			3     4
		6     5    7
	4    1      8    3


	 */

	//Below is my solution
	//O(n^2) time and O(n) space
	public static int triangleMinSumPath2(List<int[]> triangle){
		int levels = triangle.size();
		int dp[] = new int[levels];

		dp = triangle.get(levels-1);

		System.out.println(levels);
		System.out.println(dp);


		//bottom up Dijkstra
		for(int l = levels-2; l>=0 ; l--){
			for(int i = 0; i<=l; i++){
				System.out.println(dp[i] +" : "+dp[i+1] +" : "+triangle.get(l)[i]);
				dp[i] = Math.min(dp[i], dp[i+1]) + triangle.get(l)[i];
			}
		}
		return dp[0];
	}


	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;

		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}

		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}

		return total[0];
	}

}
