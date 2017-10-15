package meetup;

 /*
    		3
   		  /   \
  		 1     5
  	   /  \   /  \
  	  4   10  7  9
  	       \
  	       11

*/

import java.util.*;

public class SerializeDeserizeBT {



	public static void main(String args[]){
		SerializeDeserizeBT obj = new SerializeDeserizeBT();
		Node root = new Node(3);
		Node n1 = new Node(1);
		Node n2 = new Node(4);
		Node n3 = new Node(5);
		Node n4 = new Node(10);
		Node n5 = new Node(11);
		Node n6 = new Node(7);
		Node n7 = new Node(9);

		root.left = n1;
		root.right = n3;

		n1.left = n2;
		n1.right =  n4;
		n4.right = n5;

		n3.left = n6;
		n3.right =n7;

		System.out.println("Pre Order Traversal : ");
		obj.preOrderTraversal(root);

		System.out.println();
		System.out.println("Serialized Array : ");
		List<Integer> res = new ArrayList<Integer>();
		obj.serializeBinaryTree(root, res);

		for(Integer i : res){
			System.out.print(i+",");
		}

		Node n = obj.deserializeBT(res);

		System.out.println();
		System.out.println("Pre Order Traversal After DeSerialization: ");
		obj.preOrderTraversal(n);


	}



	public void serializeBinaryTree(Node root,List<Integer> arr){

		if(root == null ){
			arr.add(-1);
			return;
		}
		arr.add(root.data);
		serializeBinaryTree(root.left, arr);
		serializeBinaryTree(root.right,arr);

	}

	int index = 0;
	public Node deserializeBT(List<Integer> arr){

		if(index == arr.size() || arr.get(index) == -1){
			index+=1;
			return null;
		}

		Node root = new Node(arr.get(index));
		index += 1;

		root.left = deserializeBT(arr);
		root.right = deserializeBT(arr);

		return root;

	}

	public void preOrderTraversal(Node root){

		if(root != null){
			System.out.print(root.data+" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);

		}
	}
}

class Node {
		int                     data;
		Node left;
		Node right;

	Node(int d) {
		this.data = d;
	}
}