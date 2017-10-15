package com.tree;

import java.util.*;

public class UniqueBST {

	public static void main(String argsp[]) {
		UniqueBST bst = new UniqueBST();
		bst.generateTrees(3);
	}

	public List<Node> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<Node>();
		}

		return helper(1, n);
	}

	public List<Node> helper(int m, int n) {
		List<Node> result = new ArrayList<Node>();
		if (m > n) {
			result.add(null);
			return result;
		}

		for (int i = m; i <= n; i++) {
			List<Node> ls = helper(m, i - 1);
			List<Node> rs = helper(i + 1, n);
			for (Node l : ls) {
				for (Node r : rs) {
					Node curr = new Node(i);
					curr.left = l;
					curr.right = r;
					result.add(curr);
				}
			}
		}

		return result;
	}

}

