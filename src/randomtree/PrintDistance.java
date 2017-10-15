package randomtree;

//Objec­tive: - Given nodes in a binary tree, find the dis­tance between them.
/*
		  5
	  /     \
	10         15
 /	   \	    /   \
20     25   30   35
         \
         45

 */

public class PrintDistance {

	public static int leftLeavesSum = 0;

	public int findDistance(Node root, int n1, int n2) {
		int x           = Pathlength(root, n1) - 1;
		int y           = Pathlength(root, n2) - 1;
		int lcaData     = findLCA(root, n1, n2).data;
		int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public int findPathLength(Node root, int n1){
		if(root == null){

			int x = 0;

			if(root.data == n1) return x + 1;

			 x = findPathLength(root.left,n1);

			return 0;

		}
		return 0;
	}


	/*
		  5
	  /     \
	10         15
 /	   \	    /   \
20     25   30   35
         \
         45

 */

	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			System.out.println("x :"+x +" root.data :"+root.data);
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				System.out.println("root.data :"+root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	/*
		  5
	  /     \
	10         15
 /	   \	    /   \
20     25   30   35
         \
         45

 */

	public Node findLCA(Node root, int n1, int n2) {

		if (root != null) {
			System.out.println("root.data :"+root.data);
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node left  = findLCA(root.left, n1, n2);
			Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}

	public void leftLeafSum(Node root,Node parent) {

		if (root != null) {
			leftLeafSum(root.left, root);

			if (root.left == null && root.right == null &&
					parent.left == root) {
				leftLeavesSum = leftLeavesSum + root.data;
			}
			leftLeafSum(root.right, root);
		}

	}




	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		PrintDistance i = new PrintDistance();
		System.out.println("Distance between 45 and 20 is : "
				+ i.findDistance(root, 45, 20));

		i.leftLeafSum(root,root);
		System.out.println(leftLeavesSum);
	}
}

class Node {
	int  data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}