package com.tree.examples;
/*

Objec­tive: Given a binary tree, find the sum of all the nodes which are left as well as leaves nodes.
Approach:

Approach is quite simple.
Do the inorder traversal
check if node if the left child and leaf node.
If yes then add it to the sum.
See the code for more understanding.

           10
          /   \
         5     15
        /  \     \
       18   12    8
            /     /  \
           6     5    2

 */
public class LeftLeavesSum {

	// Do the inorder traversal
	// check if node if the left child and leaf node
	// if yes then add it to the sum
	public static int leftLeavesSum = 0;

	public static void inOrderTraversal(TreeNode root)
	{
		if(root != null)
		{
			inOrderTraversal(root.left);
			System.out.print(" "+root.data);
			inOrderTraversal(root.right);
		}
	}

	public static void preOrderTraversal(TreeNode root)
	{
		if(root != null)
		{
			System.out.print(" "+root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static void postOrderTraversal(TreeNode root)
	{
		if(root != null)
		{
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(" "+root.data);
		}
	}


	public static void leftSum(TreeNode root, TreeNode parent) {
		if (root != null) {
			leftSum(root.left, root);
			if (root.left == null && root.right == null && parent.left == root) {
				leftLeavesSum += root.data;
			}
			leftSum(root.right, root);
		}
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(18);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(2);

		System.out.print("Inorder : ");inOrderTraversal(root);
		System.out.println();
		System.out.print("Preorder : ");preOrderTraversal(root);
		System.out.println();
		System.out.print("postorder : ");postOrderTraversal(root);
		System.out.println();

		leftSum(root, root);
		System.out.println("Sum of left leaves: " + leftLeavesSum);
	}
}
 
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}