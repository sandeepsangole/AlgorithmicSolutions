package com.tree;

/*

1
        / \
       2   5
      / \   \
     3   4   6

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

import java.util.*;

public class FlattenTree {

	Node root;

	public static void main(String args[]) {
		FlattenTree tree = new FlattenTree();

		Node root  = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		root.left = node2;
		root.right = node5;

		root.left.left = node3;
		root.left.right = node4;

		root.right.right = node6;
		tree.preOrder(root);
		tree.flattenBinaryTree(root);
		tree.flattenBinaryTree(root);
		tree.flattenBinaryTreeWithQueue(root);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	//	tree.printPaths(root);

		tree.sumNumbers(root);
	}

	public void preOrder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void preOrderFlattenTree(Node root, Queue<Node> queue) {

		if (root != null) {
			queue.add(root);
			preOrder(root.left);
			preOrder(root.right);
		}


	}


	public Node flattenBinaryTreeWithQueue(Node root) {
		if (root == null) return null;

		Queue<Node> queue = new LinkedList<Node>();
		preOrderFlattenTree(root, queue);

		root = queue.poll();
		while (!queue.isEmpty()) {
			root.right = queue.poll();
			root.left = null;
		}
		return root;
	}

	public void printPaths(Node root){
		if(root == null) return;

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subList = new ArrayList<Integer>();

		printPathsDFS(root,result,subList);
	}

	public ArrayList<ArrayList<Integer>> printPathsDFS(Node t,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> subList){


		if(t.left == null && t.right == null){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(subList);
			result.add(temp);
		}

		if(t.left != null){
			subList.add(t.left.data);
			printPathsDFS(t.left,result,subList);
			subList.remove(subList.size() -1);

		}
		if(t.right != null){
			subList.add(t.right.data);
			printPathsDFS(t.right,result,subList);
			subList.remove(subList.size()-1);
		}

		return result;
	}

	public int sumNumbers(Node root){
		return sumNumbersRec(root,0);
	}

	public int sumNumbersRec(Node root, int sum){
		if(root == null) return 0;

		if(root.left == null && root.right == null)
			return 10*sum+root.data;

		return sumNumbersRec(root.left,10*sum+root.data) + sumNumbersRec(root.right,10*sum+root.data);

	}


	public boolean hasPathSum(Node root, int sum){
		if(root == null)
			return false;

		if(root.data == sum && (root.left == null && root.right == null)){
			return true;
		}

		return hasPathSum(root.left,sum-root.data) || hasPathSum(root.right,sum-root.data);
	}


	public Node flattenBinaryTree(Node root) {

		if (root == null) return null;


		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		while (p != null || !stack.isEmpty()) {

			if (root.right != null) {
				stack.push(root.right);
			}

			if (root.left != null) {
				root.right = root.left;
				root.left = null;
			}
		else if(!stack.isEmpty()){
				Node temp = stack.pop();
				p.right = temp;
			}
			p = p.getRight();
		}

		return root;
	}

}

