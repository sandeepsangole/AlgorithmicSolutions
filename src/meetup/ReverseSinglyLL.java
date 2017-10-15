package meetup;

public class ReverseSinglyLL {

	private static class LinkListNode {

		int no;
		LinkListNode next;

		LinkListNode(int no){
			this.no = no;
		}
	}

	LinkListNode head;

	private static LinkListNode reverLL(LinkListNode head){

		if(head == null && head.next == null){
			return head;
		}
		LinkListNode next = head.next;
		LinkListNode prev = null;

		while(next != null){
			LinkListNode tmp = next.next;
			head.next = prev;
			next.next = head;

			prev = head;
			head = next;
			next = tmp;

		}


		return head;
	}

	 static void printLL(LinkListNode node){

		while(node != null){
			System.out.print(node.no+"->");
			node = node.next;
		}
	}

	public static void main(String args[]){

		ReverseSinglyLL rl = new ReverseSinglyLL();
		LinkListNode head = new LinkListNode(1);
		LinkListNode node1 = new LinkListNode(2);
		LinkListNode node2 = new LinkListNode(3);
		LinkListNode node3 = new LinkListNode(4);

		head.next = node1;
		node1.next = node2;
		node3.next = node3;

		printLL(head);

		System.out.println("\n\n");
		printLL(reverLL(head));

	}

}



