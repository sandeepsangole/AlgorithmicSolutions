package sandy.tree;

import java.util.Stack;

public class  BSTExamples {
	static BTNode root;

	public static void main(String[] args) {
		root = buildTree();
		TreeTraversals traverse = new TreeTraversals();
		System.out.println(traverse.levelOrderTraversal(root));
	/*	System.out.println(traverse.inOrderTraversal(root));

		BSTExamples ex = new BSTExamples();
		ex.isValidBST(root);
		System.out.println(ex.kthSmallestElement(root,5));

		System.out.println(ex.findLCA(root,new BTNode(1),new BTNode(6)).data);
*/
	}
	/*
		Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


 */

	public void sortedArrayToBST(int[] arr){
		if(arr == null || arr.length == 0)
			return;

		sortedArrayToBST(arr,0,arr.length -1);
	}

	public BTNode sortedArrayToBST(int[] arr , int start, int end){

		if(start > end)
			return null;

		int mid = (start + end) / 2;
		BTNode root = new BTNode(arr[mid]);

		root.left = sortedArrayToBST(arr,start,mid-1);
		root.right = sortedArrayToBST(arr,mid+1,end);

		return root;
	}

/*

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 */



/*
		LCA BST
 */
	public BTNode findLCA(BTNode root,BTNode node1, BTNode node2){

		if(root.data > node1.data && root.data < node2.data){
			return root;
		}else if(root.data > node1.data && root.data > node2.data){
			return findLCA(root.left,node1,node2);
		}else if(root.data < node1.data && root.data < node2.data){
			return findLCA(root.right,node1,node2);
		}
		return root;

	}


	public void isValidBST(BTNode root) {

		if (root == null) {
			return;
		}
		System.out.println(isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));

	}

	public boolean isValidBST(BTNode node, double min, double max) {

		if (node == null) {
			return true;
		}

		if (node.data <= min || node.data >= max) {
			return false;
		}

		return isValidBST(node.left, min, node.data) &&
				isValidBST(node.right, node.data, max);
	}

	/*
		Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. - Binary Tree

	 */
		public BTNode LCABinaryTree(BTNode root , BTNode node1 , BTNode node2){

				if(root == null)
					return null;

				if(root == node1 || root == node2){
					return root;
				}

				BTNode left = LCABinaryTree(root.left, node1,node2);
			   BTNode right = LCABinaryTree(root.right,node1,node2);

				if(left != null && right != null){
					return root;
				} else if(left == null && right == null){
					return null;
				}
				else{
					return left == null ? right : left;
				}




		}

	/*
	Given a binary search tree, write a function kthSmallest to find the kth smallest ele-
	ment in it. (1  k  BST’s total elements)
	 */
	public int kthSmallestElement(BTNode node  , int k){
		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode p = node;
		int result = 0;
		while(p != null || !stack.isEmpty()){

			if(p != null) {
				stack.push(p);
				p = p.left;
			}
			else{
				BTNode temp = stack.pop();
				k--;
				if(k ==0){
					result =  temp.data;
				}

				if(temp.right != null) {
					p = temp.right;
				}
			}

		}
		return result;
	}


	public BTNode flattenBST(BTNode root) {

		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode        temp  = root;

		while (temp != null || !stack.isEmpty()) {

			if (temp.right != null) {
				stack.push(temp.right);
			}

			if (temp.left != null) {
				temp.right = temp.left;
				temp.left = null;
			} else if (!stack.isEmpty()) {
				BTNode t = stack.pop();
				temp.right = t;
			}

			temp = temp.right;
		}

		return temp;
	}

	public static BTNode buildTree() {
		BTNode root  = new BTNode(8);
		BTNode node2 = new BTNode(3);
		BTNode node3 = new BTNode(10);

		BTNode node4 = new BTNode(1);
		BTNode node5 = new BTNode(6);

		BTNode node6 = new BTNode(4);
		BTNode node7 = new BTNode(7);

		BTNode node14 = new BTNode(14);
		BTNode node13 = new BTNode(13);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node5.left = node6;
		node5.right = node7;

		node3.right = node14;
		node14.left = node13;

		return root;
	}


}
