package linklistnew;

public class ListFromString {

	ListStringNode head = null;
	ListStringNode current = null;

	/*
	Create a function that creates a linked list out of a string, where

each node contains a single letter. Also create a string representation

of such a list for debugging purposes.
	 */
	public ListStringNode listFromString(String str){

		if(str == null || str.length() == 0){
			return head;
		}

		for(int i=0;i<str.length();i++){
			if(head == null){
				head = new ListStringNode(str.charAt(i));
				current = head;
			}
			else{
				current.next = new ListStringNode(str.charAt(i));
				current = current.next;
			}
		}

		return head;
	}

	public void printList(){
		if(head == null) return;
		ListStringNode current = head;
		while(current != null){
			System.out.print(current.c);
			current = current.next;
			if(current != null)
				System.out.print("->");
		}
	}

	public static void main(String args[]){
		ListFromString obj = new ListFromString();
		obj.listFromString("TESTing my program");
		System.out.println();
		obj.printList();

	}

}

class ListStringNode{

	char c;
	ListStringNode next;
	ListStringNode(char c){
		this.c = c;
	}

}