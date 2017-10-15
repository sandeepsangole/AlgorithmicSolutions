package com.tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**               40
 *             /    \
 *            20     60
 *           / \    /  \
 *         10  30  50   70
 *
 */
public class BinaryTree {

	Node root;

	BinaryTree() {
		root = null;
	}

	void insert(int data) {
		if (root == null) {
			this.root = new Node(data);
			return;
		}

		insert(root, data);
	}

	int countOfNodes(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftCount  = countOfNodes(root.getLeft());
			int rightCount = countOfNodes(root.getRight());
			return leftCount + rightCount + 1;
		}

	}

	int heightOfTree(Node root) {
		int maxHeight = Integer.MIN_VALUE;
		if (root == null) {
			return 0;
		} else {
			int leftHeiht   = heightOfTree(root.getLeft());
			int rightHeight = heightOfTree(root.getRight());
			if (leftHeiht < rightHeight)
				maxHeight = rightHeight;
			else
				maxHeight = leftHeiht;

			return maxHeight + 1;


		}
	}

	int maxNode(Node root) {
		int max_value = Integer.MIN_VALUE;

		if (root == null)
			return 0;
		else {
			int leftMax  = maxNode(root.getLeft());
			int rightMax = maxNode(root.getRight());

			if (leftMax > rightMax) {
				max_value = leftMax;
			} else {
				max_value = rightMax;
			}


			if (max_value > root.getData())
				return max_value;
			else
				return root.getData();


		}
	}

	Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);

		}
		if (data < root.getData()) {
			root.left = insert(root.getLeft(), data);
		} else {
			root.right = insert(root.getRight(), data);
		}

		return root;
	}

	void preOrderIterative(Node root) {

		if (root == null) {
			return;
		} else {
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while (!stack.isEmpty()) {

				Node temp = stack.pop();
				System.out.print(temp.getData() + " ");
				if (temp.getRight() != null)
					stack.push(temp.getRight());
				if (temp.getLeft() != null)
					stack.push(temp.getLeft());
			}


		}
	}

	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrder(root.getRight());
		}
	}

	void inOrderIterative(Node root) {
		if (root == null) {
			return;
		} else {
			Stack<Node> stack       = new Stack<Node>();
			Node        currentNode = root;
			boolean     done        = false;
			while (!done) {

				if (currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.getLeft();
				} else {
					if (stack.isEmpty()) {
						done = true;
						return;
					}
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + " ");
					currentNode = currentNode.getRight();
				}
			}

		}
	}

	void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public ArrayList<Integer> postorderTraversalIterative(Node root) {

		ArrayList<Integer> lst = new ArrayList<Integer>();

		if (root == null)
			return lst;

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		Node prev = null;
		while (!stack.empty()) {
			Node curr = stack.peek();

			// go down the tree.
			//check if current node is leaf, if so, process it and pop stack,
			//otherwise, keep going down
			if (prev == null || prev.left == curr || prev.right == curr) {
				//prev == null is the situation for the root node
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					System.out.print(curr.getData() + " ");
					lst.add(curr.getData());
				}

				//go up the tree from left node
				//need to check if there is a right child
				//if yes, push it to stack
				//otherwise, process parent and pop stack
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					System.out.print(curr.getData() + " ");
					lst.add(curr.getData());
				}

				//go up the tree from right node
				//after coming back from right node, process parent node and pop stack.
			} else if (curr.right == prev) {
				stack.pop();
				System.out.print(curr.getData() + " ");
				lst.add(curr.getData());
			}

			prev = curr;
		}

		//System.out.print(lst.toArray());

		return lst;
	}

	public List<Integer> postorderTraversalIterativeEasy(Node root) {
		List<Integer> res = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node temp = stack.peek();
			if (temp.left == null && temp.right == null) {
				Node pop = stack.pop();
				System.out.print(pop.getData() + " ");
				res.add(pop.getData());
			} else {
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}

				if (temp.left != null) {
					stack.push(temp.left);
					temp.left = null;
				}
			}
		}

		return res;
	}


	void postOrder(Node root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}

	void levelOrderTraversal(Node root)
	{
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> subLst = new ArrayList<>();
		if(root == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			Node tmp = queue.poll();
			if(tmp != null) {
				System.out.print(tmp.getData()+" ");
				subLst.add(tmp.getData());
				if (tmp.getLeft() != null) {
					queue.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					queue.offer(tmp.getRight());
				}


			}
			else
			{
				list.add(subLst);
				subLst.clear();
				System.out.println();
				if(!queue.isEmpty())
					queue.offer(null);
			}


		}


	}

	public boolean search(Node root, int data) {
		boolean found = false;
		if(root == null)
		{
			return found;
		}

		if(root.getData() == data)
			return true;

		if(data < root.getData())
		{
			search(root.getLeft(),data);
		}
		else
		{
			search(root.getRight(),data);
		}

		return found;
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		//

		bt.insert(40);
		bt.insert(20);
		bt.insert(60);
		bt.insert(10);
		bt.insert(30);
		bt.insert(50);
		bt.insert(70);



		/*Scanner scan = new Scanner(System.in);
		char    ch;
		do {
			System.out.println("Enter your option...");
			System.out.println("1.Insert element ");
			System.out.println("2.search Element");
			System.out.println("3.Count No of Nodes ");
			System.out.println("4.Height of Tree  ");
			System.out.println("5.Max Node ");

			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter integer element to insert");
					bt.insert(scan.nextInt());
					break;
				case 2:
					System.out.println("Enter integer element to search");
					bt.search(bt.root,scan.nextInt());
					break;
				case 3:

					System.out.println("No Of Nodes :" + bt.countOfNodes(bt.root));
					break;
				case 4:
					System.out.println("Height is ...:" + bt.heightOfTree(bt.root));
					break;
				case 5:
					System.out.println("Max Node is ...:" + bt.maxNode(bt.root));
					break;
				default:
					System.out.println("Wrong option \n");
					break;
			}
*/


			System.out.print("\nLevel Order Traversal: ");
			bt.levelOrderTraversal(bt.root);


			System.out.print("\nIn order Recursive: ");
			bt.inOrder(bt.root);

			System.out.print("\nIn order Iterative: ");
			bt.inOrderIterative(bt.root);

			System.out.print("\nPre order Recursive: ");
			bt.preOrder(bt.root);

			System.out.print("\nPre order Iterative: ");
			bt.preOrderIterative(bt.root);

			System.out.print("\nPost order Recursive: ");
			bt.postOrder(bt.root);


			System.out.print("\nPost order Iterative: ");
			bt.postorderTraversalIterative(bt.root);

			System.out.print("\nPost order Iterative Easy: ");
			bt.postorderTraversalIterativeEasy(bt.root);




		/*	System.out.println("\n\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');*/
	}
}
