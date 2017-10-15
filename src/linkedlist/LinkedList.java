package linkedlist;

/*

 5->1-> 2-> 4->null
 head
 */

import java.util.*;

public class LinkedList {

	static ListNode head;
	int count;
/*
WRite code to delete duplicates from unsorted linked list
//O(n)
	     5  -> 2->  4->  2-> 3
		            prev     node
set - 5 2 4

	*/

	void deleteDups(ListNode node) {
		Set<Integer> set  = new HashSet<Integer>();
		ListNode     prev = null;
		while (node != null) {

			if (set.contains(node.val)) {
				prev.next = node.next;
			} else {
				set.add(node.val);
				prev = node;
			}
			node = node.next;
		}

	}

	/*
	 Implement algoritham to find the kth to last element of singly linked list
	 */
	public ListNode nthToLast(ListNode head, int k) {
		ListNode p1 = head;
		ListNode p2 = head;

	/* Move p1 k nodes to the list */
		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return null;
			}
			p1 = p1.next;
		}

		//Move both pointers at same pace When p1 hit the end p2 will be at the right place
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;


	}

	public static void main(String[] args) {
		LinkedList obj = new LinkedList();

		obj.addNodeAtStart(6);
		obj.addNodeAtStart(5);
		obj.addNodeAtStart(4);
		obj.addNodeAtStart(3);
		obj.addNodeAtStart(2);
		obj.addNodeAtStart(1);
		//obj.addNodeAtPosition(2,2);
		System.out.println("Linked List : ");
		obj.reverseLinkedList(head);
		System.out.println(obj.isPalindrome(head));
		System.out.println("Linked List Updated : ");
		obj.printLinkedList(head);

		/*System.out.println("-->" + obj.nthToLast(head,2).val);
		System.out.println("After Linked List : ");
		obj.deleteDups(head);
		obj.printLinkedList(head);
		System.out.println("-->" + obj.nthToLast(head,2).val);
		head = obj.reverseLinkedList(head);
		System.out.println();
		obj.printLinkedList(head);*/

	}

	public void addNodeAtStart(int newNodeVal) {
		ListNode addNode = new ListNode(newNodeVal);
		ListNode p       = this.head;
		if (this.head == null) {
			this.head = addNode;

		} else {
			addNode.next = head;
			this.head = addNode;
		}
	}


	public ListNode addNodeAtEnd(int newNodeVal) {
		ListNode newNode = new ListNode(newNodeVal);
		ListNode p       = head;
		if (head == null) {
			head = newNode;

		} else {
			while (p.next != null) {
				p = p.next;
			}
			p.next = newNode;
			// 5->1-> 2-> 4->null

		}

		return head;
	}

	public ListNode addNodeAtPosition(int newNodeVal, int position) {
		ListNode newNode = new ListNode(newNodeVal);
		ListNode p       = head;
		if (head == null) {
			head = newNode;

		} else {
			while (position > 0 && p != null) {
				--position;
				p = p.next;
			}
			newNode.next = p.next;
			p.next = newNode;
			// 5->1->   ->2-> 4->null
		}
		return head;
	}
/*

 */

	public ListNode reverseLinkedList(ListNode head) {
			/*
			prev -> 1     ->  2  ->  3  ->  4  ->  5
		   null  <-1     <-  2  ->  3  ->  4  ->  5
                 prev     head    next  tmp
			*/

		if (head == null || head.next == null) {
			return head;
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

		return head;
	}


	public void printLinkedList(ListNode head) {
		ListNode p = head;
		if (p == null) {
			System.out.println("List is empty ");
		} else {
			while (p != null) {
				System.out.print(p.val + "->");
				p = p.next;
			}
		}
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode newHead = new ListNode(0);
		ListNode p1      = l1;
		ListNode p2      = l2;
		ListNode p3      = newHead;


		while (p1 != null && p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}

			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}

			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
			carry = carry / 10;

		}

		if (carry == 1)
			p3.next = new ListNode(1);

		return newHead.next;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode pre = fake;
		int      i   = 0;
		ListNode p   = head;
		while (p != null) {
			i++;
			if (i % k == 0) {
				pre = reverse(pre, p.next);
				p = pre.next;
			} else {
				p = p.next;
			}
		}
		return fake.next;
	}

	public ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode curr = last.next;
		while (curr != next) {
			last.next = curr.next;
			curr.next = pre.next;
			pre.next = curr;
			curr = last.next;
		}
		return last;
	}

	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null)
			return true;

		//find list center
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null;

		//reverse second part of the list
		ListNode p1 = secondHead;
		ListNode p2 = p1.next;

		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondHead.next = null;

		//compare two sublists now
		ListNode p = (p2 == null ? p1 : p2);
		ListNode q = head;
		while (p != null) {
			if (p.val != q.val)
				return false;

			p = p.next;
			q = q.next;

		}

		return true;
	}


	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode p = h;
		while (p.next != null && p.next.next != null) {
			//use t1 to track first node
			ListNode t1 = p;
			p = p.next;
			t1.next = p.next;

			//use t2 to track next node of the pair
			ListNode t2 = p.next.next;
			p.next.next = p;
			p.next = t2;
		}
		return h.next;
	}


}

class ListNode {

	int      val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}
