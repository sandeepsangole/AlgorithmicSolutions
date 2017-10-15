package linklistnew;

/*Write methods to perform run-length encoding(aka RLE) and
	decoding on a linked list of capital letters. Let the encoding work as
	shown by the following examples (use the $ symbol to separate the
	number from the letter):
*/

import java.util.*;
import java.util.stream.Collector;

public class ListEncoding {


	ListNodeString head;

	public ListNodeString rleEncodeList(ListNodeString h) {

		if (h == null) {
			return h;
		}
		//Try using just character
		String ch = null;
		int count = 0;
		ListNodeString            newHead = new ListNodeString();
		ListNodeString            current = h;
		ListNodeString newLst = newHead;
		while (current != null) {

			if(ch == null || ch.length() == 0){
					ch = current.val;
					count++;
			}
			else{
				if(ch.equals(current.val)){
					count++;
				}
				else{
					newHead.next = count > 1 ? new ListNodeString(count + "$" + ch) : new ListNodeString(ch);
					ch = current.val;
					count = 1;
					newHead = newHead.next;
				}
			}
			current = current.next;
		}

		newHead.next = count > 1 ? new ListNodeString(count + "$" + ch) : new ListNodeString(ch);

		return newLst.next;
	}
	/*
	Write methods to perform run-length encoding(aka RLE) and
	decoding on a linked list of capital letters. Let the encoding work as
	shown by the following examples (use the $ symbol to separate the
	number from the letter):
	 */

	public ListNodeString rleDecodeList(ListNodeString h) {

			if(h == null)
			{
				return h;
			}

		ListNodeString current = h;
		ListNodeString newHead = new ListNodeString();
		ListNodeString decodedHead = newHead;

		while(current != null){
			String tmp = current.val;
			if(tmp.length() > 1){

				int repeat = Character.getNumericValue(tmp.charAt(0));
				for(int i =0;i<repeat;i++){
					newHead.next = new ListNodeString(String.valueOf(tmp.charAt(2)));
					newHead = newHead.next;
				}

			}
			else{
				newHead.next = new ListNodeString(String.valueOf(tmp.charAt(0)));
				newHead = newHead.next;
			}
			current = current.next;
		}

		return decodedHead.next;

	}
		/*
		Write a method to delete a key from the first occurrence from left to
		right in an RLE-encoded list. If the key isn't present, do nothing. Use
		printLinked list to test.
		 */
		ListNodeString deleteFromRLEList(char key, ListNodeString list) {

			ListNodeString newHead = list;

			if(list == null) return list;

			if(list.val.equals(String.valueOf(key))){
				list = list.next;
				return list;
			}
			else {


					ListNodeString prev = list;
					ListNodeString current = list.next;

				while(current != null){

					String val = current.val;
					if(current.val.length() > 1 && current.val.equals(String.valueOf(key))){
						val = Character.getNumericValue(current.val.charAt(0) -1 )+"$"+current.val.charAt(2);
						current.val = val;
					}
					else if(current.val.equals(String.valueOf(key))){
						prev.next = current.next;
						return newHead;
					}

					prev = current;
					current = current.next;
				}

			}

			return newHead;
		}


	public void buildList(String val) {
		ListNodeString node = new ListNodeString(val);
		if (head == null) {
			head = node;
			return;
		}

		ListNodeString pointer  = head;
		ListNodeString previous = head;
		while (pointer != null) {
			previous = pointer;
			pointer = pointer.next;
		}
		previous.next = node;
	}

	class ListNodeString {

		String         val;
		ListNodeString next;

		ListNodeString(String val) {
			this.val = val;
		}
		ListNodeString(){

		}
	}

	public void printList(ListNodeString h) {
		if (h == null) return;
		ListNodeString current = h;
		while (current != null) {
			System.out.print(current.val);
			current = current.next;
			if (current != null)
				System.out.print("->");
		}
	}


	public static void main(String args[]) {
		ListEncoding ob = new ListEncoding();
		ob.buildList("B");
		ob.buildList("A");
		ob.buildList("A");
		ob.buildList("A");

		ob.buildList("A");
		ob.buildList("A");
		ob.buildList("A");
		ob.buildList("C");
		ob.buildList("C");
		ob.buildList("D");
		ob.buildList("E");

		ob.printList(ob.head);
		ListNodeString newLst = ob.rleEncodeList(ob.head);
		System.out.println();
		ob.printList(newLst);

		System.out.println();
		System.out.println();
		ob.printList(ob.rleDecodeList(newLst));

		System.out.println();
		System.out.println();
		newLst = ob.deleteFromRLEList('C',newLst);

		ob.printList(newLst);
	}

}
