package Arrays;

/*
Given an array nums, write a function to move all 0’s to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].


	[0, 1, 0, 3, 12]
	 i  j
*/

import java.util.*;

public class MoveZeros {

	public static void main(String args[]) {
		MoveZeros obj    = new MoveZeros();
		int[]     result = obj.moveZeros(new int[] { 5, 1, 0, 3, 12 });
		System.out.println(Arrays.toString(result));
	}

	public int[] moveZeros(int[] arr) {


		if (arr == null || arr.length == 0) {
			return arr;
		}

		int i = 0;
		int j = 0;

		while (j < arr.length) {

			if (arr[ j ] == 0) {
				j++;
			} else {
				arr[ i ] = arr[ j ];
				i++;
				j++;
			}
		}

		while (i < arr.length) {
			arr[ i ] = 0;
			i++;
		}

		return arr;
	}

}

