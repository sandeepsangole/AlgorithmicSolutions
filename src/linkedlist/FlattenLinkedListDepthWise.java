package linkedlist;

import java.util.Stack;

public class FlattenLinkedListDepthWise {

	static class Node {
		int  data;
		Node next;
		Node down;

		Node(int d) {
			this.data = d;

		}

	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.down = new Node(7);
		head.next.down.down = new Node(9);
		head.next.down.down.down = new Node(14);
		head.next.down.down.down.down = new Node(15);
		head.next.down.down.down.down.next = new Node(23);
		head.next.down.down.down.down.next.down = new Node(24);
		head.next.down.next = new Node(8);
		head.next.down.next.down = new Node(16);
		head.next.down.next.down.down = new Node(17);
		head.next.down.next.down.down.next = new Node(18);
		head.next.down.next.down.down.next.next = new Node(19);
		head.next.down.next.down.down.next.next.next = new Node(20);
		head.next.down.next.down.down.next.next.next.down = new Node(21);
		head.next.down.next.next = new Node(10);
		head.next.down.next.next.down = new Node(11);
		head.next.down.next.next.next = new Node(12);

		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		System.out.println();
		Node headNew = flatten(head);
		while (headNew != null) {
			System.out.print(headNew.data + " ");
			headNew = headNew.next;
		}
	}

	static Node flattenListRecur(Node root) {
		if (root.next == null && root.down == null) {
			return root;
		} else if (root.next == null && root.down != null) {
			root.next = root.down;
			root.down = null;
			return flattenListRecur(root.next);
		} else if (root.next != null && root.down == null) {
			return flattenListRecur(root.next);
		} else {
		// If both child nodes are not null then
			Node next = root.next;
			root.next = root.down;
			Node last = flattenListRecur(root.next);
			//assign the next node to last node
			last.next = next;
			return flattenListRecur(next);
		}
	}


	private static Node flatten(Node head) {
		if (head == null) return null;
		Stack<Node> s = new Stack<>();
		s.push(head);
		Node currNew = null;
		Node headNew = null;
		while (!s.isEmpty()) {
			Node n = s.pop();
			while (n != null) {
				if (headNew == null) {
					headNew = n;
					currNew = n;
				} else {
					currNew.next = n;
					currNew = currNew.next;
				}
				if (n.next != null) {
					s.push(n.next);
				}
				n = n.down;
			}
		}
		currNew.next = null;

		return headNew;
	}

}