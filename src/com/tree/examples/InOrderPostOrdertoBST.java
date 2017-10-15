package com.tree.examples;

import com.tree.Node;

public class InOrderPostOrdertoBST {
	public static void main(String args[]) {
		InOrderPostOrdertoBST obj = new InOrderPostOrdertoBST();
		TreeNode root = obj.buildTree(new int[] { 4, 2, 5, 1, 6, 7, 3, 8 }, new int[] { 4, 5, 2, 6, 7, 8, 3, 1 });
		obj.preOrder(root);
	}

	void preOrder(TreeNode root) {
		if (root != null) {

			System.out.print(root.data+ " ");
			preOrder(root.left);

			preOrder(root.right);

		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inStart   = 0;
		int inEnd     = inorder.length - 1;
		int postStart = 0;
		int postEnd   = postorder.length - 1;
		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
	                          int[] postorder, int postStart, int postEnd) {

		if (inStart > inEnd || postStart > postEnd)
			return null;
		int      rootValue = postorder[ postEnd ];
		TreeNode root      = new TreeNode(rootValue);
		int      k         = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[ i ] == rootValue) {
				k = i;
				break;
			}
		}
		System.out.println("instart "+inStart +" k :"+k);
		//System.out.print(k-1 );
		//System.out.print(postStart);
		//System.out.print(postStart + k - (inStart + 1)+" ");System.out.println();

		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
				postStart + k - (inStart + 1));
		// Becuase k is not the length, it it need to -(inStart+1) to get the length
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k -
				inStart, postEnd - 1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1
		return root;


	}
}