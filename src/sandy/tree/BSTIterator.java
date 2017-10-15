package sandy.tree;

import java.util.*;

/*
			 50
		  /    \
		 25     75
		/  \    /  \
	  10  15  60  80
	 */

public class BSTIterator {
	Stack<BTNode> stack;


	public BSTIterator(BTNode root) {
		stack = new Stack<BTNode>();
		while (root != null) {
			stack.push(root); //50 25 10
			root = root.left;
		}
	}
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		BTNode node = stack.pop();
		int result = node.data;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}

}
