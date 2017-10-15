package Arrays;

/*
11 Summary Ranges
Given a sorted integer array without duplicates, return the summary of its ranges for consecutive numbers.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

0,1,2,4,5,7
i   j
*/

import java.util.*;

public class SummaryRanges {

	public static void main(String[] args) {
		SummaryRanges obj    = new SummaryRanges();
		List<String>  result = obj.getSummaryRanges(new int[] { 0, 1, 2,2,2,2,2 ,4, 5, 7 });
		System.out.println(result);
	}

	public List<String> getSummaryRanges(int[] arr) {

		List<String> list = new ArrayList<String>();
		int          i    = 0;
		int          j    = 0;

		while (j < arr.length) {
			if (j == arr.length - 1) {
				list.add("" + arr[ j ]);
				break;
			}
			if (arr[ j ] == arr[ j + 1 ] - 1) {
				j++;
			} else {
				list.add(arr[ i ] + "->" + arr[ j ]);
				j++;
				i = j;


			}
		}

		return list;
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return result;
		if (nums.length == 1) {
			result.add(nums[ 0 ] + "");
		}
		int pre   = nums[ 0 ]; // previous element
		int first = pre; // first element of each range
		for (int i = 1; i < nums.length; i++) {
			if (nums[ i ] == pre + 1) {
				if (i == nums.length - 1) {
					result.add(first + "->" + nums[ i ]);
				}
			} else {
				if (first == pre) {
					result.add(first + "");
				} else {
					result.add(first + "->" + pre);
				}
				if (i == nums.length - 1) {
					result.add(nums[ i ] + "");
				}
				first = nums[ i ];
			}
			pre = nums[ i ];
		}
		return result;
	}


}



