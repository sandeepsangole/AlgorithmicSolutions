package dp;

import java.util.Arrays;

public class StairCase {

	public static void main(String args[]){
		StairCase sc = new StairCase();
		System.out.println(sc.countWays(4));
	}

	int countWays(int n){
		int[] memo = new int[n+1];
		Arrays.fill(memo,-1);

		return countWays(n,memo);
	}

	int countWays(int n,int[] memo) {
		System.out.println("N :" + n);
		if (n < 0) {
			return 0;

		} else if (n == 0) {
			return 1;
		} else if (memo[ n ] > -1) {
			return memo[ n ];
		}
		memo[ n ] = countWays(n - 1, memo) +
				countWays(n - 2, memo) +
				countWays(n - 3, memo);
		System.out.println(" memo[n] " + memo[ n ] + " n : " + n);
		return memo[ n ];
	}
}
