package Arrays;

import java.util.ArrayList;
import java.util.List;



public class MaximumPathDiamond {

	public static void main(String args[]){
		int[] arr = new int[]{2};
		int[] arr1 = new int[]{3,4};
		int[] arr2 = new int[]{6,5,7};
		int[] arr3 = new int[]{4,1,8,3};
		int[] arr4 = new int[]{2,5,4};
		int[] arr5 = new int[]{6,4};
		int[] arr6 = new int[]{1};

		List<int[]> triagle = new ArrayList<int[]>();
		triagle.add(arr);
		triagle.add(arr1);
		triagle.add(arr2);
		triagle.add(arr3);
		triagle.add(arr4);
		triagle.add(arr5);
		triagle.add(arr6);

		//System.out.println(triangleMinSumPath2(triagle));

		System.out.println(get2DMatrix(triagle));


	}

	public static int[][] get2DMatrix(List<int[]> diamond) {

		int     mid = diamond.size() / 2;
		int[][] arr = new int[ mid + 1 ][ mid + 1 ];
		int     col = 0;
		for (int l = 0; l <= mid; l++) {
			for (int i = l; i <= l + mid; i++) {
				int val = i > mid ? (l - (i - mid)) : l;
				arr[ col ][ l ] = diamond.get(i)[ val ];
				col++;

			}
			col = 0;
		}

		return arr;
	}


}
