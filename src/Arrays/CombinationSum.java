package Arrays;

import java.util.*;

/*
 and a target number (T)Given a set of candidate numbers (C), find all unique combi- nations in C where the
candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.
Note: All numbers (including target) will be positive integers. Elements in a combi- nation (a1, a2, ... , ak)
must be in non-descending order. (ie, a1 <= a2 <= ... <= ak). The solution set must not contain duplicate
combinations. For example, given candidate set 2,3,6,7 and target 7, A solution set is:

 */
public class CombinationSum {

	public static void main(String args[]) {
		CombinationSum obj = new CombinationSum();
		System.out.println(obj.combinationSum(new int[] { 2, 3, 5, 6, 7 }, 7));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int
			target) {
		ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) return result;
		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, current, result);
		//return result;

		helper(result1, current, 0, target, candidates);
		return result1;
	}

	public void combinationSum(int[] candidates, int target, int j,
	                           ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(curr);
			result.add(temp);
			return;
		}
		for (int i = j; i < candidates.length; i++) {
			if (target < candidates[ i ])
				return;
			curr.add(candidates[ i ]);
			combinationSum(candidates, target - candidates[ i ], i, curr, result);
			curr.remove(curr.size() - 1);
		}
	}

	public void helper(ArrayList<ArrayList<Integer>> result, List<Integer> curr, int start,
	                   int target, int[] candidates) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}
		if (target < 0) {
			return;
		}
		int prev = -1;
		for (int i = start; i < candidates.length; i++) {
			if (prev != candidates[ i ]) { // each time start from different element
				curr.add(candidates[ i ]);
				helper(result, curr, i + 1, target - candidates[ i ], candidates); // and use next element only
				curr.remove(curr.size() - 1);
				prev = candidates[ i ];
			}
		}
	}

}
