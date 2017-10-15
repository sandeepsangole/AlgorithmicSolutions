package important.specials;

import important.specials.Node;

import java.util.*;


/*
		 50
	  /    \
	 25     75
	/  \    /  \
  10  30  60  80
					  \
						100
  */

public class BSTIterator {

	Stack<Node> stack;

	BSTIterator(Node root) {

		stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {

		Node result = stack.pop();
		int  res    = result.data;

		if (result.right != null) {
			result = result.right;

			while (result != null) {
				stack.push(result);
				result = result.left;
			}

		}

		return res;
	}


}
