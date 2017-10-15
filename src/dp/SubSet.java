package dp;

import java.util.*;

public class SubSet {

	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		List<Integer>                 sol = new ArrayList<Integer>();
		int[]                         arr = { 3,1 };
		SubSet                        obj = new SubSet();
		Arrays.sort(arr);
		obj.findSubSets(arr, res, sol, 0);
		System.out.println(res);
	}

	public void findSubSets(int[] arr, ArrayList<ArrayList<Integer>> res, List<Integer> sol, int index) {

		res.add(new ArrayList<Integer>(sol));
		System.out.println(res);
		for (int i = index; i < arr.length; i++) {
			System.out.println(" i : " + i + " Sol " + sol);
			sol.add(arr[ i ]);
			findSubSets(arr, res, sol, i + 1);
			sol.remove(sol.size() - 1);
		}

	}
}
