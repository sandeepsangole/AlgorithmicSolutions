package linklistnew;

import java.util.*;

public class LinkedListImplementation {


	static ListNode head;
	static ListNode head1;

	//Add to linked list at start
	public void addAtStart(int val) {

		ListNode node = new ListNode(val);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}

	}

	//Print linked list

	public void printList() {
		ListNode pointer = head;
		while (pointer != null) {
			System.out.print(pointer.val + "->");
			pointer = pointer.next;
		}
	}

	public void printList2(ListNode h) {
		ListNode pointer = h;
		while (pointer != null) {
			System.out.print(pointer.val + "->");
			pointer = pointer.next;
		}
	}

	//Add at end

	//  1->2->3

	public void addAtEnd(int val) {
		ListNode node = new ListNode(val);
		if (head == null) {
			head = node;
			return;
		}

		ListNode pointer  = head;
		ListNode previous = head;
		while (pointer != null) {
			previous = pointer;
			pointer = pointer.next;
		}
		previous.next = node;
	}

	public void addAtEnd2(int val) {
		ListNode node = new ListNode(val);
		if (head1 == null) {
			head1 = node;
			return;
		}

		ListNode pointer  = head1;
		ListNode previous = head1;
		while (pointer != null) {
			previous = pointer;
			pointer = pointer.next;
		}
		previous.next = node;
	}

	//Find duplicates in singly linked list
	//1->2->3->2->4->5->2
	//      p  pt
	public void removeDuplicatesSet() {

		if (head == null) {
			return;
		}
		Set<Integer> set     = new HashSet<Integer>();
		ListNode     pointer = head;
		ListNode     pre     = head;
		while (pointer != null) {
			if (set.contains(pointer.val)) {
				pre.next = pointer.next;
			} else {
				set.add(pointer.val);
				pre = pointer;
			}
			pointer = pointer.next;


		}

	}

//remove duplicate singly linked list brute force


	public void removeDuplicatesBruteForce() {

		if (head == null) {
			return;
		}

		ListNode startPointer = head;
		while (startPointer != null) {

			int      val  = startPointer.val;
			ListNode pre  = startPointer;
			ListNode next = startPointer.next;
			while (next != null) {
				//1->2->3->->4->5->2

				if (val == next.val) {
					pre.next = next.next;
				} else {
					pre = next;
				}
				next = next.next;

			}

			startPointer = startPointer.next;

		}

	}


	//Reverse Linked list
/*

null<-1<-2->3->4->5
p	   h  n  t
         p     n
 */
	public void reverseLinkedList() {
			/*
			prev -> 1     ->  2  ->  3  ->  4  ->  5
		   null  <-1     <-  2  ->  3  ->  4  ->  5
                 prev     head    next  tmp
			*/

		if (head == null || head.next == null) {
			return;
		}

		ListNode prev = null;
		ListNode next = head.next;

		while (next != null) {

			ListNode tmp = next.next;
			next.next = head;
			head.next = prev;

			prev = head;
			head = next;
			next = tmp;


		}


	}

	public void reverseLL() {

		if (head == null || head.next == null) {
			return;
		}

		ListNode prev = null;
		ListNode n    = head.next;

		while (n != null) {

			ListNode t = n.next;
			n.next = head;
			head.next = prev;


			prev = head;
			head = n;
			n = t;

		}

	}

	public ListNode mergeTwoSortedLL(ListNode p1, ListNode p2) {

		ListNode temp    = new ListNode();
		ListNode newHead = temp;
		while (p1 != null && p2 != null) {

			if (p1.val < p2.val) {
				temp.next = new ListNode(p1.val);
				p1= p1.next;
			} else {
				temp.next = new ListNode(p2.val);
				p2=p2.next;
			}

			temp = temp.next;


		}

		if (p1 != null) {
			temp.next = p1;
		} else if (p2 != null) {
			temp.next = p2;
		}

		return newHead.next;

	}

	public static void main(String args[]) {
		LinkedListImplementation obj = new LinkedListImplementation();
		obj.addAtEnd(1);
		obj.addAtEnd(4);
		obj.addAtEnd(7);
		obj.addAtEnd(11);


		obj.printList();

		LinkedListImplementation obj1 = new LinkedListImplementation();
		obj1.addAtEnd2(2);
		obj1.addAtEnd2(6);
		obj1.addAtEnd2(9);
		obj1.addAtEnd2(10);

		System.out.println();
		obj1.printList2(head1);

		ListNode n = obj.mergeTwoSortedLL(head,head1);
		System.out.println();
		obj1.printList2(n);

		/*obj.reverseLL();
		System.out.println();
		obj.printList();*/



/*		ListNode output = obj.addLinkedList(head, head1);
		System.out.println();
		obj1.printList2(output);*/

	/*	obj.removeDuplicatesBruteForce();
		System.out.println();
		obj.printList();*/
/*		System.out.println();System.out.println();
		System.out.println(obj.findNthToLast(3));*/
	}

	public ListNode addLinkedList(ListNode n1, ListNode n2) {
		// Same Length
		// different length
		// carry
		//create new linked list

		ListNode p1      = n1;
		ListNode p2      = n2;
		ListNode newHead = null;
		int      carry   = 0;
		while (p1 != null && p2 != null) {

			if (p1 != null) {
				carry = carry + p1.val;
			}

			if (p2 != null) {
				carry = carry + p2.val;
			}

			if (newHead == null) {
				newHead = new ListNode(carry % 10);
			} else {
				ListNode pre = null;
				ListNode ptr = newHead;
				while (ptr != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = new ListNode(carry % 10);
			}

			carry = carry / 10;
			p1 = p1.next;
			p2 = p2.next;


		}

		return newHead;
	}


	public int findNthToLast(int n) {

		if (head == null) {
			return 0; //error
		}

		ListNode fastPointer = head;
		ListNode slowPointer = head;

		for (int i = 0; i < n; i++) {
			if (fastPointer == null) return 0;//error
			fastPointer = fastPointer.next;

		}

		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}

		return slowPointer.val;


	}

}
