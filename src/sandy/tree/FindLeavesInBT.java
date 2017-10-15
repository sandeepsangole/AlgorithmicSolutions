package sandy.tree;

import com.tree.Node;

import java.util.*;

public class FindLeavesInBT {

	static BTNode root;

	public static void main(String[] args) {
		root = buildTree();
		FindLeavesInBT obj = new FindLeavesInBT();
		System.out.println(obj.findLeaves(root));


	}

	public static BTNode buildTree() {
		BTNode root  = new BTNode(1);
		BTNode node2 = new BTNode(2);
		BTNode node3 = new BTNode(3);
		BTNode node4 = new BTNode(4);

		BTNode node6 = new BTNode(6);
		BTNode node7 = new BTNode(7);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node6;
		//node3.right = node7;

		return root;
	}


	public List<List<Integer>> findLeaves(BTNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, root);
		return result;
	}

	// traverse the tree bottom-up recursively
	private int helper(List<List<Integer>> list, BTNode root) {
		if (root == null)
			return -1;
		int left  = helper(list, root.left);
		int right = helper(list, root.right);
		int curr  = Math.max(left, right) + 1;
		// the first time this code is reached is when curr==0,
		//since the tree is bottom-up processed.
		if (list.size() <= curr) {
			list.add(new ArrayList<Integer>());
		}
		list.get(curr).add(root.data);
		return curr;
	}
}
