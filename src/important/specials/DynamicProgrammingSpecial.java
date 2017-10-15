package important.specials;

import java.util.*;

public class DynamicProgrammingSpecial {


	public static void main(String args[]) {
		DynamicProgrammingSpecial obj = new DynamicProgrammingSpecial();
		System.out.println("Min Change :" + obj.minCoinChange(new int[] { 1, 2, 3 }, 5));

		//Total no of ways to get change
		System.out.println("Total Ways to get Change : " + obj.totalWaystoGetChange(new int[] { 1, 2, 3 }, 5));

		//Egg Drop Problem
		System.out.println("Egg Drop Problem :" + obj.eggDrop(2, 10));

		//Staircase count ways
		System.out.println("StairCase : " + obj.stairCaseCountWays(10));
	}

	/*
		Given coins of certain denominations and total.Find min of no of coins to form total
	 */
	public int minCoinChange(int[] coins, int total) {

		return minCoinChange(coins, total, new HashMap<Integer, Integer>());
	}

	int minCoinChange(int[] coins, int total, HashMap<Integer, Integer> map) {

		if (total == 0) return 0;

		if (map.containsKey(total)) return map.get(total);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {

			if (coins[ i ] > total) {
				continue;
			}

			int val = minCoinChange(coins, total - coins[ i ], map);
			if (val < min)
				min = val;

		}

		min = min == Integer.MAX_VALUE ? min : min + 1;
		map.put(total, min);

		return min;
	}

	/*
		Total number of ways to get total using bottom up approach
	*/

	public int totalWaystoGetChange(int[] coins, int total) {

		int[][] temp = new int[ coins.length + 1 ][ total + 1 ];

		for (int i = 0; i < coins.length; i++) {
			temp[ i ][ 0 ] = 1;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coins[ i - 1 ] > j) {
					temp[ i ][ j ] = temp[ i - 1 ][ j ];
				} else {
					temp[ i ][ j ] = temp[ i - 1 ][ j ] + temp[ i ][ j - coins[ i - 1 ] ];
				}
			}
		}

		return temp[ coins.length ][ total ];

	}

	/*
		Egg drop Problem
	 */

	public int eggDrop(int eggs, int floors) {
		return eggDrop(eggs, floors, new int[ eggs + 1 ][ floors + 1 ]);
	}

	public int eggDrop(int eggs, int floors, int[][] memo) {

		if (eggs == 1) {
			return floors;
		}

		if (floors == 0) {
			return 0;
		}

		if (memo[ eggs ][ floors ] > 0) {
			return memo[ eggs ][ floors ];
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= floors; i++) {

			int val = 1 + Math.max(eggDrop(eggs - 1, i - 1, memo), eggDrop(eggs, floors - i, memo));
			if (val < min) min = val;
		}

		memo[ eggs ][ floors ] = min;

		return min;
	}

	/*
		Staircase problem ; Given no of steps and ways to climbFind no ways of ways person reach to top.
	   no of steps - 1,2,3
	 */

	public int stairCaseCountWays(int n) {

		int[] memo = new int[ n + 1 ];
		Arrays.fill(memo, -1);
		return stairCaseCountWays(n, memo);
	}

	public int stairCaseCountWays(int n, int[] memo) {

		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		if (memo[ n ] > -1) {
			return memo[ n ];
		}

		memo[ n ] = stairCaseCountWays(n - 1, memo) + stairCaseCountWays(n - 2, memo) +
				stairCaseCountWays(n - 2, memo);

		return memo[ n ];
	}

	/*
		Longest Common Subsequence
	*/

	public int LCS(String str1, String str2) {
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();

		return LCS(str1Array, 0, str2Array, 0);
	}

	public int LCS(char[] str1Array, int len1, char[] str2Array, int len2) {

		if (str1Array.length == len1 || str2Array.length == len2)
			return 0;

		if (str1Array[ len1 ] == str2Array[ len2 ]) {
			return 1 + LCS(str1Array, len1++, str2Array, len2++);
		} else {
			return Math.max(LCS(str1Array, len1++, str2Array, len2),
					LCS(str1Array, len1, str2Array, len2++));
		}
	}

/*
	Min operation to convert one string into another
	insert
	update
	delete

	source = risk
	            sl
	target = rsk
	           tl
*/

	public int minOpertionsOneStringToAnother(String str1, String str2) {

		return minOpertionsOneStringToAnother(str1, str1.length() - 1, str2, str2.length());

	}

	public int minOpertionsOneStringToAnother(String str1, int source, String str2, int target) {

		if (source < 0) {
			return 0;
		}

		if (target < 0) {
			return 0;
		}

		if (str1.charAt(source) == str2.charAt(target)) {
			return minOpertionsOneStringToAnother(str1, source - 1, str2, target - 1);
		} else {
			return 1 + min(minOpertionsOneStringToAnother(str1, source - 1, str2, target),
					minOpertionsOneStringToAnother(str1, source, str2, target - 1),
					minOpertionsOneStringToAnother(str1, source - 1, str2, target - 1));
		}

	}

	public int min(int a, int b, int c) {
		int temp = Math.min(a, b);
		return Math.min(temp, c);
	}


}
