
public class DoubltyLinkedList {
	
	MessageLinks head;
	MessageLinks tail;
	int dllSize = 0;
	
	DoubltyLinkedList()
	{
		dllSize =0;
	}
	
		public static void main(String[] args) {
			DoubltyLinkedList dll = new DoubltyLinkedList();
			dll.addLinkLast("Last Link");
			dll.removeLast();
		}
	
	public void addLinkFront(String msg)
	{	
		MessageLinks node = new MessageLinks();
		node.setMsg(msg);
		
		if(head == null)
		{
			node.setNext(null);
			node.setPrevious(null);
			head = tail = node;
		}
		else
		{
			node.setNext(head);
			head.setPrevious(node);
			head = node;
			if(tail == null)
			tail =node;	
		}
		dllSize++;
		System.out.println("New Record : Added at front \n");
		traverseRight();
	}
	
	public void addLinkLast(String msg)
	{
		MessageLinks node = new MessageLinks();
		node.setMsg(msg);
		
		if(tail != null)
		{
			
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
		}
		if(head == null)
		{
			head=node;
			tail=node;
		}
		dllSize++;
		System.out.println("New Record : Added at last \n");
		traverseRight();
	}
	
	public void removeFirst()
	{
		if(dllSize ==0) System.out.println("DLL is empty ... "+dllSize);
		
		MessageLinks temp = head.getNext();
		temp.setPrevious(null);
		head = temp;
		dllSize--;
		System.out.println("Deleted first \n");
		traverseRight();
		
	}
	
	public void removeLast()
	{
		if(dllSize ==0) 
		{
			System.out.println("DLL is empty ... "+dllSize);
			return;
		}
		
		
		
		if(dllSize == 1)
		{
			tail =null;
			head=null;
		}
		else {
			MessageLinks temp = tail.getPrevious();
			temp.setNext(null);
			tail = temp;
		}
		dllSize--;
		
		System.out.println("Deleted last ");
		traverseRight();
	}
	
	public void traverseRight()
	{
		MessageLinks temp = head;
		if(temp == null)
		{
			System.out.println("DLL is empty ... "+dllSize);
			return;
		}
		else
		{
			while(temp != null)
			{
				System.out.println(temp.getMsg());
				temp=temp.getNext();
			}
		}
	}
	
	public void traverseLeft()
	{
		MessageLinks temp = tail;
		if(temp == null)
		{
			System.out.println("DLL is empty ... "+dllSize);
			return;
		}
		else
		{
			while(temp != null)
			{
				System.out.println(temp.getMsg());
				temp=temp.getPrevious();
			}
		}
	}

}


class MessageLinks{
	
	String msg;
	MessageLinks next;
	MessageLinks previous;
	
	MessageLinks(){}
	
	MessageLinks(String msg,MessageLinks next,MessageLinks previous)
	{
		this.msg = msg;
		this.next = next;
		this.previous = previous;
	}
	public MessageLinks getPrevious() {
		return previous;
	}
	public void setPrevious(MessageLinks previous) {
		this.previous = previous;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public MessageLinks getNext() {
		return next;
	}
	public void setNext(MessageLinks next) {
		this.next = next;
	}
	
}
