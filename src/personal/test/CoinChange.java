package personal.test;

/* Dynamic Programming Java implementation of Coin
   Change problem */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CoinChange
{

	public int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {

		//if total is 0 then there is nothing to do. return 0.
		if ( total == 0 ) {
			return 0;
		}

		//if map contains the result means we calculated it before. Lets return that value.
		if ( map.containsKey(total) ) {
			return map.get(total);
		}

		//iterate through all coins and see which one gives best result.
		int min = Integer.MAX_VALUE;
		for ( int i=0; i < coins.length; i++ ) {
			//if value of coin is greater than total we are looking for just continue.
			if( coins[i] > total ) {
				continue;
			}
			//recurse with total - coins[i] as new total
			int val = minimumCoinTopDown(total - coins[i], coins, map);

			//if val we get from picking coins[i] as first coin for current total is less
			// than value found so far make it minimum.
			if( val < min ) {
				min = val;
			}
		}

		//if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
		min =  (min == Integer.MAX_VALUE ? min : min + 1);

		//memoize the minimum for current total.
		map.put(total, min);
		return min;
	}

	static long countWays(int S[], int m, int n)
	{
		//Time complexity of this function: O(mn)
		//Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n+1];

		// Initialize all table values as 0
		Arrays.fill(table, 0);   //O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i=0; i<m; i++)
			for (int j=S[i]; j<=n; j++)
				table[j] += table[j-S[i]];

		return table[n];
	}

	/*// Driver Function to test above function
	public static void main(String args[])
	{
		int arr[] = {1, 2, 3};
		int m = arr.length;
		int n = 4;
		System.out.println(countWays(arr, m, n));
	}*/

	public static void main ( String args[] ) {
		int total = 5;
		int coins[] = {1,2,3};
		CoinChange cc = new CoinChange();
		Map<Integer, Integer> map = new HashMap<>();
		int topDownValue = cc.minimumCoinTopDown(total, coins, map);
		//int bottomUpValue = cc.minimumCoinBottomUp(total, coins);

		System.out.print(String.format("Bottom up and top down result %s", topDownValue));

	}
}