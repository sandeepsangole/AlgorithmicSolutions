package sandy.tree;

import com.tree.Node;

public class ConstructTreeFromInOrderAndPostOrder {

	public static void main(String[] args) {
		int[] inOrder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postOrder = { 4, 5, 2, 6, 7, 8, 3, 1 };
		ConstructTreeFromInOrderAndPostOrder obj     = new ConstructTreeFromInOrderAndPostOrder();
		BTNode noderoot= obj.createTree(inOrder, postOrder);
		TreeTraversals obj1 = new TreeTraversals();
		obj.inOrder(noderoot);
	}


	void  inOrder(BTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	public BTNode createTree(int[] inOrder, int[] postOrder) {
		BTNode result = createTree(inOrder, postOrder, 0, inOrder.length - 1, postOrder.length - 1);

		return result;
	}

	private BTNode createTree(int[] inOrder, int[] postOrder, int start, int end, int index) {

		if (start > end) {
			return null;
		}

		BTNode node = new BTNode(postOrder[ index ]);

		//find in inorder
		int i;
		for (i = 0; i <= end; i++) {
			if (inOrder[ i ] == node.data) {
				break;
			}
		}
/*
		 int[] inOrder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postOrder = { 4, 5, 2, 6, 7, 8, 3, 1 };
 */
		//int index = 7 - (7-3+1);
		//end - i + 1 - Identify In order left elements
		//i - mid

		node.left = createTree(inOrder, postOrder, start, i - 1, index - (end - i + 1));
		node.right = createTree(inOrder, postOrder, i + 1, end, index - 1);
		return node;


	}
}
