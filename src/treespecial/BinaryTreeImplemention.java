/*
 * 			 50
 * 			/   \
 *		 25		   75	 
 *     /   \     /   \
 *  10     35   60   85
 *
 *
 *
 *
 */

package treespecial;

import java.util.*;
import java.util.Stack;

public class BinaryTreeImplemention {

	BinaryTreeNode root = null;


	//post order Iterative method
	public void postOrderTraversal(BinaryTreeNode root) {
		if (root == null) return;

		ArrayList<BinaryTreeNode> res     = new ArrayList<BinaryTreeNode>();
		Stack<BinaryTreeNode>     stack   = new Stack<BinaryTreeNode>();
		BinaryTreeNode            prev    = null;
		BinaryTreeNode            current = root;
		stack.push(current);

		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.peek();
			if (prev == null) {
				if (current.left != null) {

				} else if (current.right != null) {

				}
			}
		}
	}

	// preorder Iterative method
	public ArrayList<BinaryTreeNode> preOrderTraversalIterative(BinaryTreeNode root) {

		if (root == null)
			return null;

		Stack<BinaryTreeNode>     stack   = new Stack<BinaryTreeNode>();
		ArrayList<BinaryTreeNode> res     = new ArrayList<BinaryTreeNode>();
		boolean                   done    = false;
		BinaryTreeNode            current = root;

		while (!done) {


			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					current = stack.pop();
					res.add(current);
					current = current.getRight();
				}

			}

		}
		return res;
	}

	//Inorder Iterative method
	public void inOrderTraversalIterative(BinaryTreeNode root) {
		if (root == null)
			return;

		Stack<BinaryTreeNode> stack       = new Stack<BinaryTreeNode>();
		BinaryTreeNode        currentNode = root;

		stack.push(root);

		while (!stack.isEmpty()) {
			BinaryTreeNode parent = currentNode;

			if (currentNode != null) {
				currentNode = currentNode.getLeft();
				if (currentNode != null) {
					stack.push(currentNode);
				}
			} else {
				System.out.println(stack.peek());
				stack.pop();


			}
		}

	}


	// adding 5
	public void addNodeToMyTree(int newNodeValue) {
		BinaryTreeNode addNode = new BinaryTreeNode(newNodeValue);

		if (root == null) {
			root = addNode;

		} else {
			BinaryTreeNode current = root;
			while (true) {


				BinaryTreeNode parent = current;

				if (newNodeValue < current.getData()) {
					current = parent.getLeft();
					if (current == null) {
						parent.left = addNode;
						return;

					}
				} else if (newNodeValue > current.getData()) {
					current = parent.getRight();
					if (current == null) {
						parent.right = addNode;
						return;

					}
				}

			}

		}

	}


	public static void main(String[] args) {
		BinaryTreeImplemention tree = new BinaryTreeImplemention();

		tree.addNodeToMyTree(50);
		tree.addNodeToMyTree(25);
		tree.addNodeToMyTree(75);
		tree.addNodeToMyTree(10);
		tree.addNodeToMyTree(35);
		tree.addNodeToMyTree(60);
		tree.addNodeToMyTree(85);

		tree.inOrderTraversalIterative(tree.root);


	}


}
