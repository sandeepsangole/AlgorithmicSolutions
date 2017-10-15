package com.tree;

public class Node {

	 Node left;
	 Node right;
	 int data;


	Node(){
		left=null;
		right=null;
		data=0;
	}

	Node(int data)
	{
		this.left = null;
		this.right = null;
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}



	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
