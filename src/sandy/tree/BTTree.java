package sandy.tree;

import com.sun.javaws.exceptions.BadMimeTypeResponseException;
import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import jdk.nashorn.internal.runtime.regexp.joni.ast.BackRefNode;

import java.util.*;

/*

				1
			 /   \
		   2	   3
       /   \     \
     4       6    7

 */
public class BTTree {
	static BTNode root;

	public static void main(String[] args) {
		root = buildTree();

		TreeTraversals traverse = new TreeTraversals();
		System.out.println(traverse.preOrderTraversal(root));
		System.out.println(traverse.inOrderTraversal(root));
		System.out.println(traverse.postOrderTraversal(root));
		System.out.println(traverse.verticalOrderTraversal(root));
		System.out.println(traverse.levelOrderTraversal(root));
		traverse.printAllPaths(root);
	System.out.println(traverse.hasPathSum(root,11));
		System.out.println(traverse.hasPathSumIterative(root,11));
		traverse.sumOfPath(root);

		System.out.println(LCABinaryTree(root,new BTNode(4),new BTNode(7)));
		System.out.println(treePathSum(root));
		rootToLeafPaths(root);
		System.out.println(hasPathSumRecursive(root,8));

		System.out.println(hasPathSumIterative(root,8));


	}


	//1.	===============================================

	/*
	Given a binary tree, sum all the root to leaf nodes and return the sum.

	Ex:
			1
			/   \
			2      3
			/   \       \
			4     6       7

	here ans: 124 + 126 + 137 = 387
	*/
	static int treePathSum(BTNode node) {
		return treePathSumFinal(node, 0);
	}

	static int treePathSumFinal(BTNode node, int val) {

		//base case
		if (node == null) {
			return 0;
		}

		val = val * 10 + node.data;
		if (node.left == null && node.right == null)
			return val;

		return treePathSumFinal(node.left, val) + treePathSumFinal(node.right, val);
	}
//	===============================================

/*
For the below example tree, all root-to-leaf paths are:
1 –> 2 –> 3
1 –> 2 –> 6
1 –> 3 –> 7



Algorithm:
Use a path array path[] to store current root to leaf path. Traverse from root to all leaves in top-down fashion.
While traversing, store data of all nodes in current path in array path[]. When we reach a leaf node, print the path array.

 */

	public static ArrayList<ArrayList<Integer>> rootToLeafPaths(BTNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer>            list   = new ArrayList<Integer>();
		if(root == null)
			return result;
		list.add(root.data);
		rootToLeafPathsFinal(root, result, list);
		System.out.print(result);

		for(List<Integer> l : result){

		}

		return result;
	}

	public static void rootToLeafPathsFinal(BTNode node, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {

		if (node.left == null && node.right == null) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(list);
			result.add(temp);

		}

		if(node.left != null){
			list.add(node.left.data);
			rootToLeafPathsFinal(node.left,result,list);
			list.remove(list.size() - 1);
		}

		if(node.right != null){
			list.add(node.right.data);
			rootToLeafPathsFinal(node.right,result,list);
			list.remove(list.size() - 1);

		}

	}


	/*
	 Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values
	 along the path equals the given number. Return false if no such path can be found.


	 */

	public static boolean hasPathSumRecursive(BTNode node , int s){

	   if(node == null){
			return false;
		}

		if(node.data ==s && node.left == null && node.right == null){
			return true;
		}

		return hasPathSumRecursive(node.left,s - node.data) ||
				hasPathSumRecursive(node.right, s- node.data);


	}

	public static boolean hasPathSumIterative(BTNode node, int sum) {

		if (node == null) return false;
		Queue<BTNode>  nodes  = new LinkedList<BTNode>();
		Queue<Integer> values = new LinkedList<Integer>();

		nodes.offer(node);
		values.offer(node.data);

		while (!nodes.isEmpty()) {

			BTNode curr = nodes.poll();
			int    val  = values.poll();

			if (curr.left == null && curr.right == null && val == sum) {
				return true;
			}

			if (curr.left != null) {
				nodes.offer(curr.left);
				values.offer(val + curr.left.data);

			}

			if (curr.right != null) {

				nodes.offer(curr.right);
				values.offer(val + curr.right.data);
			}

		}

		return false;
	}
/*
Given a binary tree, flatten it to a linked list in-place.
For example, Given
1
/\
2  5
/\  \
34   6
The flattened tree should look like:
1
\
	2
		\
			3
				\
					4 \
5 \
6


 */

public void flattenBT(BTNode node) {
	Stack<BTNode> stack = new Stack<BTNode>();
	BTNode        temp  = node;

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

}

	public static BTNode LCABinaryTree(BTNode root , BTNode node1 , BTNode node2){

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

	public int countNodes(BTNode node){
		if(root == null){
			return 0;
		}
		else
		{
			int left = countNodes(root.left);
			int right = countNodes(root.right);
			return left + right + 1;
		}
	}

	public int getHeightofBT(BTNode root){

		int height = Integer.MIN_VALUE;

			if(root == null){
				return 0;
			}
		else {
				int left  = getHeightofBT(root.left);
				int right = getHeightofBT(root.right);

				if (left > right) {
					height = left;
				} else {
					height = right;
				}

			}
		return height + 1;
	}

/*

Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
For example, given the below binary tree and sum = 22,

 */



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

		node3.right = node7;

		return root;
	}


}
