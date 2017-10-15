package dp;
/*
Dice Throw Problem: Given n dice each with m faces, numbered from 1 to m,
find the number of ways to get sum X. X is the summation of values on each face
when all the dice are thrown.

N - dice
m  - faces(1...m)

m = 10
n = 4

dice (1,2,3,4)
mFace(1,3,5,10)


Sum = 15

dice =
 */

import java.util.*;

public class Dice {


	public static void main(String args[]) {

		Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
	//	System.out.println(numberOfWays(4, 2, 1,memo)); // 0
		int[][] temp = new int[3][6];
		System.out.println(nWaysDiceMemo(4, 2, 5,temp)); // 2

		/*System.out.println(numberOfWays(2, 2, 3,memo));
		System.out.println(numberOfWays(6, 3, 8,memo)); // 21
		System.out.println(numberOfWays(4, 2, 5,memo)); // 4
		System.out.println(numberOfWays(4, 3, 5,memo)); // 6*/

	}




	public static int nWaysDiceMemo(int mFaces,int nDice,int sum,int[][] dp){

		if(nDice == 0 && sum == 0){
			return 1;
		}

		if(dp[nDice][sum] == 0){

			for(int i = 1;i<=mFaces;i++){
				if((nDice - 1>=0) && (sum - i) >= 0)
				dp[nDice][sum] += nWaysDiceMemo(mFaces,nDice - 1,sum-i,dp);
			}
		}

		return dp[nDice][sum];
	}
}


