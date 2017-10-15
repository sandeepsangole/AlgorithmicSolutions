package meetup;

import java.util.*;

public class SerializeDeserizeBST {

	public static void main(String args[]){
		Node r = buildBinaryTree();
		List<Integer> lst = new ArrayList<>();
		serializeBinarySearchTree(r , lst);
		for(Integer i : lst){
			System.out.print(i +", ");
		}


		Node  n = derializeBinaryTree(lst,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);

		System.out.println("Pre Order Traversal : ");
		preOrderTraversal(n);
	}

	public static void serializeBinarySearchTree(Node root,List<Integer> arr) {

		if(root == null){
			return;
		}

		arr.add(root.data);
		serializeBinarySearchTree(root.left, arr);
		serializeBinarySearchTree(root.right,arr);

	}

	static int index = 0;
	public static Node derializeBinaryTree(List<Integer> arr , double min , double max) {

		if(index >= arr.size()) return null;

		Node root = null;
		if(arr.get(index) > min && arr.get(index) < max){
			root = new Node(arr.get(index));
			index+=1;

			root.left = derializeBinaryTree(arr,min,root.data);
			root.right = derializeBinaryTree(arr,root.data,max);

		}

		return root;

	}

	public static void preOrderTraversal(Node root) {

		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);

		}
	}

	public static Node buildBinaryTree() {

		Node root  = new Node(50);
		Node node2 = new Node(25);
		Node node3 = new Node(75);
		Node node4 = new Node(10);

		Node node6  = new Node(30);
		Node node7  = new Node(60);
		Node node8  = new Node(80);
		Node node9  = new Node(100);
		Node node10 = new Node(101);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node6;

		node3.left = node7;
		node3.right = node8;

		node8.right = node9;

		//	node9.right = node10;

		return root;
	}

}