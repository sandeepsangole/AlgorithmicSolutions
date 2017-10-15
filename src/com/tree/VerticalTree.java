package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTree {

	public static void main(String args[]){


		Node root  = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node5.left = node11;
		node11.right = node12;

		node3.left = node6;
		node3.right = node7;
		node7.right = node9;
		node6.right = node8;

		node8.left=node10;


		int left = printVertical(root.left,"left");
		int right = printVertical(root.left,"right");

		if(left > right)
			System.out.println(left);
		else
			System.out.println(right);
		//preOrder(root);


	}

	 static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public static int printVertical(Node root,String side){
		Map<Integer,List<Node>> map = new TreeMap<Integer,List<Node>>();
		populateMap(root,map,0);
		return printLevel(map,side);
	}

	private static int printLevel(Map<Integer,List<Node>> map,String side){
	//	System.out.println(side);
		int count =0 ;
		for(Integer key : map.keySet()){

		//	System.out.println("key :"+key);
			if(side.equals("left") && (key == 0 || key == 1) ||
					side.equals("right") && (key == 0 || key == -1)) {
				List<Node> listNodes = map.get(key);
				count = count + listNodes.size();

			}
		}

		return count;
	}

	private static void populateMap(Node root, Map<Integer,List<Node>> map,int level){
		if(root == null){
			return;
		}
		List<Node> listNodes = null;
		if(map.containsKey(level)){
			listNodes = map.get(level);
		}else{
			listNodes = new ArrayList<Node>();
			map.put(level, listNodes);
		}
		listNodes.add(root);
		populateMap(root.left,map,level-1);
		populateMap(root.right,map,level+1);
	}

}
