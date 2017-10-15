package sandy.tree;

public class ConstructTreeFromInOrderPreOrder {
	static int index = 0;

	public static void main(String[] args) {
		int[]                            inOrder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[]                            preOder = { 1, 2, 4, 5, 3, 7, 6, 8 };
		ConstructTreeFromInOrderPreOrder obj     = new ConstructTreeFromInOrderPreOrder();
		BTNode node = obj.createTree(inOrder, preOder);
		obj.inOrder(node);
	}


	void  inOrder(BTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public BTNode createTree(int[] inorder, int[] preOrder) {
		BTNode result = createTree(inorder, preOrder, 0, inorder.length - 1);
		return result;

	}

	private BTNode createTree(int[] inOrder, int[] preOrder, int start, int end) {

		if (start > end) {
			return null;
		}

		//find root in Inorder
		int i;
		for (i = 0; i < inOrder.length; i++) {
			if (inOrder[ i ] == preOrder[index]) {
				break;
			}
		}

		/*
		 int[] inOrder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postOrder = { 4, 5, 2, 6, 7, 8, 3, 1 };
      */
		BTNode root = new BTNode(preOrder[ index ]);
		index++;

		root.left = createTree(inOrder, preOrder, start, i - 1);
		root.right = createTree(inOrder, preOrder, i + 1, end);

		return root;
	}
}
