package com.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, design an algorithm which creates a linked
 * list of all the nodes at each depth (e.g., if you have a tree
 * with depth D, you'll have D linked lists).
 */
public class Q4 {
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result  = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode>            current = new LinkedList<TreeNode>();
		if (root != null) current.add(root);

		while (!current.isEmpty()) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null) current.add(parent.left);
				if (parent.right != null) current.add(parent.right);
			}
		}
		return result;
	}

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		Queue<TreeNode>                 q      = new LinkedList<TreeNode>();
		if (root != null) q.add(root);
		while (!q.isEmpty()) {
			int                  size  = q.size();
			LinkedList<TreeNode> level = new LinkedList<TreeNode>();
			for (int i = 0; i < size; ++i) {
				TreeNode n = q.remove();
				level.add(n);
				if (n.left != null) q.add(n.left);
				if (n.right != null) q.add(n.right);
			}
			result.add(level);
		}
		return result;
	}

	//TEST----------------------------------
	public static void main(String[] args) {
	     /*
	      *     4
         *    / \
         *   1   5
         *  / \   \
         * 2   3   7
         *      \
         *       6
         */
		TreeNode n1 = new TreeNode(1), n2 = new TreeNode(3),
				n3 = new TreeNode(5), r = new TreeNode(4);
		n1.left = new TreeNode(2);
		n1.right = n2;
		n2.right = new TreeNode(6);
		r.left = n1;
		r.right = n3;
		n3.right = new TreeNode(7);
		TreeNode.printTree(r);
		System.out.println();

		System.out.println("createLevelLinkedList:");
		ArrayList<LinkedList<TreeNode>> levels = createLevelLinkedList(r);
		for (LinkedList<TreeNode> level : levels) {
			for (TreeNode node : level) {
				System.out.println(node + " ");
			}
			System.out.println();
		}
		System.out.println("\ncreateLevelLinkedList2:");
		levels = createLevelLinkedList2(r);
		for (LinkedList<TreeNode> level : levels) {
			for (TreeNode node : level) {
				System.out.println(node + " ");
			}
			System.out.println();
		}
	}
}

class TreeNode {
	public int      value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent; /* only used for certain cases */

	public TreeNode(int x) {
		value = x;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public static void printTree(TreeNode n) {
		if (n == null) return;
		System.out.print(n.value);
		printTree(n.left, 0, true);
		printTree(n.right, 0, false);
	}

	private static void printTree(TreeNode n, int level, boolean isLeft) {
		if (n == null) return;
		for (int i = 0; i < level; ++i) System.out.println("  ");
		if (isLeft)
			System.out.println(("/- " + n.value));
		else
			System.out.println(("\\- " + n.value));
		printTree(n.left, level + 1, true);
		printTree(n.right, level + 1, false);
	}
}