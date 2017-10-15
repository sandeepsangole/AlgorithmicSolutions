package sandy.tree;

import java.util.*;

public class BSTree {


	static BTNode root;

	public static void main(String[] args) {
		root = buildTree();

		TreeTraversals traverse = new TreeTraversals();
		System.out.println(traverse.preOrderTraversal(root));


//		System.out.println("Successor :" + inorderSuccessor(root, new BTNode(60)).data);

//		System.out.println("Successor :" + inOrderTraversal(root, new BTNode(50)).data);

		//System.out.println("Successor :" + inOrderTraversal(root, new BTNode(10)).data);

		BSTIterator it = new BSTIterator(root);
		while(it.hasNext()){
			if((it.next() == 80)) {
				if(it.hasNext()) {
					System.out.println(it.next());
					break;
				}
			}
		}
	}

	/*
			 50
		  /    \
		 25     75
		/  \    /  \
	  10  30  60  80
	 */
	public static BTNode buildTree() {
		BTNode root  = new BTNode(50);
		BTNode node2 = new BTNode(25);
		BTNode node3 = new BTNode(75);
		BTNode node4 = new BTNode(10);

		BTNode node6 = new BTNode(30);
		BTNode node7 = new BTNode(60);
		BTNode node8 = new BTNode(80);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node6;

		node3.left = node7;
		node3.right = node8;

		return root;
	}

	public static BTNode inOrderTraversal(BTNode root,BTNode p) {

		BTNode        current = root;
		Stack<BTNode> stack   = new Stack<BTNode>();
		List<Integer> result  = new ArrayList<Integer>();
		boolean isNext = false;
		while (current != null || !stack.isEmpty()) {

			if(current.data == p.data){
				isNext = true;
			}

			if (current != null) {
				stack.push(current);
				current = current.left;
				if(isNext){
					if(current != null)
					return current;
				}

			} else {
				BTNode temp = stack.pop();
				result.add(temp.data);
				current = temp.right;
				if(isNext){
					if(current != null)
					return current;
				}

			}

		}
		return current;

	}

	public static BTNode inorderSuccessor(BTNode root, BTNode p) {
		Stack<BTNode> stack = new Stack<BTNode>();
		if (root == null || p == null)
			return null;
		stack.push(root);
		boolean isNext = false;
		while (!stack.isEmpty()) {
			BTNode top = stack.pop();
			if (top.right == null && top.left == null) {
				if (isNext) {
					return top;
				}
				if (p.data == top.data) {
					isNext = true;
				}
				continue;
			}
			if (top.right != null) {
				stack.push(top.right);
				top.right = null;
			}
			stack.push(top);
			if (top.left != null) {
				stack.push(top.left);
				top.left = null;
			}
		}
		return null;
	}

}
