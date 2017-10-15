package com.tree.examples;

//Objec­tive: - Given Binary Tree, Print all the nodes which are X dis­tance from the root\

/*
Idea is very simple.
Do the pre­order tra­ver­sal, pass x as parameter.
While going down, at each level, keep reduc­ing the x by 1
When x = 0 , the means you have reached to the nodes which are at x dis­tance from root, Print them.
      1
     /  \
	2      3
	/ \     \
4     5     8
		/ \     \
     6   7     9

 */


public class PrintNodesAtKDistance {
	public void print(MyNode root, int k) {
		if (root != null) {
			if (k == 0) {
				System.out.print(" " + root.data);
			}
			print(root.left, --k);
			print(root.right, k);
		}
	}

	public void printPre(MyNode root) {
		if (root != null) {
			//if (k == 0) {
				System.out.print(" " + root.data);
		//	}
			printPre(root.left);
			printPre(root.right);
		}
	}

	/*public void printInOrder(MyNode root, int k) {
		if (root != null) {

			printInOrder(root.left, --k);
			if (k == 0) {
				System.out.print(" " + root.data);
			}
			printInOrder(root.right, k);
		}
	}

	public void printPostOrder(MyNode root, int k) {
		if (root != null) {

			printInOrder(root.left, --k);

			printInOrder(root.right, k);
			if (k == 0) {
				System.out.print(" " + root.data);
			}
		}
	}*/

	/*
	Objec­tive: - Find the max­i­mum sum leaf to root path in a Binary Tree.
	Means in all the paths from root to leaves, find the path which has the max­i­mum sum.
   */
	int maxSum = -1;
	MyNode maxLeaf = null;

	public  void findMaxSumWithPath(MyNode root, int sum) {

		if(root != null)
		{
			sum = sum + root.data;
			if(sum > maxSum && root.left == null && root.right == null){
				maxSum = sum;
				maxLeaf = root;
			}
			findMaxSumWithPath(root.left,sum);
			findMaxSumWithPath(root.right,sum);
		}

	}

	public Boolean path(MyNode root, MyNode leaf){
		if(root==null) return false;
		if ((root == leaf) ||
				path(root.left, leaf) ||
				path(root.right, leaf) )
		{
			System.out.print(" " + root.data);
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws java.lang.Exception {
		MyNode root = new MyNode(1);
		root.left = new MyNode(2);
		root.right = new MyNode(3);
		root.left.left = new MyNode(4);
		root.left.right = new MyNode(5);
		root.left.right.left = new MyNode(6);
		root.left.right.right = new MyNode(7);
		root.right.right = new MyNode(8);
		root.right.right.right = new MyNode(9);
		PrintNodesAtKDistance i = new PrintNodesAtKDistance();
		System.out.println("PreOrder : ");
		i.printPre(root);

		System.out.println("Nodes at 3 distance from root : ");
		i.print(root, 1);

		i.findMaxSumWithPath(root,0);
		System.out.println("Max Sum : "+i.maxSum);
		i.path(root,i.maxLeaf);
		/*System.out.println("Nodes at 3 distance from root : ");
		i.printInOrder(root, 4);
		System.out.println("Nodes at 3 distance from root : ");
		i.printPostOrder(root, 4);*/
	}
}

class MyNode {
	int    data;
	MyNode left;
	MyNode right;

	public MyNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

