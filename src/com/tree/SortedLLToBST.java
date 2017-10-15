package com.tree;

public class SortedLLToBST {

	public static TNode head = null;

	public BSTNode LLToBST(int start, int end, int lineno) {
		System.out.println("Start : "+start +"   End : "+end  +" lineno : "+ lineno);
		if (start > end) return null;
		int     mid       = (start + end) / 2;
		System.out.println("  mid : "+mid);
		BSTNode leftChild = LLToBST(start, mid - 1,12);
		System.out.println("  leftChild : "+(leftChild == null ? null :leftChild.data));
		BSTNode root      = new BSTNode(head.data);
		System.out.println(" root : "+(root == null ? root :root.data));
		root.left = leftChild;
		System.out.println(" root.left : "+(root.left == null ? null :root.left.data));
		head = head.next;
		System.out.println(" head : "+((head == null ? head :head.data)));
		root.right = LLToBST(mid + 1, end,20);
		System.out.println(" root.right  : "+(root.right == null ? null :root.right.data) );
		System.out.println(" ------- >> Returnnung Root  : "+root.data );
		return root;
	}

	// 1->2->3->4->5->6
	public BSTNode LLToBSTTEMP(int start, int end) {

		if (start > end) return null;
		int     mid       = (start + end) / 2;

		BSTNode leftChild = LLToBSTTEMP(start, mid - 1);
		BSTNode root      = new BSTNode(head.data);
		root.left = leftChild;
		head = head.next;
		root.right = LLToBSTTEMP(mid + 1, end);
		return root;
	}


	public int getSize() {
		TNode curr = head;
		int   size = 0;
		while (curr != null) {
			curr = curr.next;
			size++;
		}
		return size;
	}

	public void inorder(BSTNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		head = new TNode(1);
		head.next = new TNode(2);
		head.next.next = new TNode(3);
		head.next.next.next = new TNode(4);
		head.next.next.next.next = new TNode(5);

		TNode tail = new TNode(6);
		head.next.next.next.next.next = tail;

		SortedLLToBST i = new SortedLLToBST();
		BSTNode       x = i.LLToBSTTEMP(1, i.getSize());
		System.out.print("Constructed BST is :");
		i.inorder(x);

	}
}

class TNode {
	int   data;
	TNode next;

	public TNode(int data) {
		this.data = data;
		next = null;
	}
}

class BSTNode {
	int     data;
	BSTNode left;
	BSTNode right;

	public BSTNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}