public class MainLink {
	MessageLink head;
	MessageLink tail;
	
	public static void main(String[] args)
	{
		MainLink mainLink = new MainLink();
		mainLink.deleteFront();
		mainLink.addLink("First Message");
		mainLink.addLink("Second Message");
		mainLink.addLink("Third Message");
		mainLink.addAfter("First Message","after Seconf Message");
		//mainLink.deleteFront();
		mainLink.deleteParticuler("Second Message");
	}
	
	public void addLink(String msg)
	{
		MessageLink mslnk = new MessageLink();
		mslnk.setMsg(msg);
		System.out.println("Adding: "+msg);
		if(head == null)
		{
			head =mslnk;
			tail = mslnk;
		}
		else
		{
			tail.setNextMsgLink(mslnk);
			tail = mslnk;
		}
		traverse();
		
	}
	
	public void deleteFront()
	{
		if(head == null)
		{
			System.out.println("Linked list is empty"); return ;
			
		}
		MessageLink tmp = head;
		head = tmp.getNextMsgLink();
		if(head == null)
		{
			tail = null;
		}
		System.out.println("Deleted..."+tmp.getMsg());
		traverse();
		
	}
	
	public void addAfter(String msgAfter, String newMsg)
	{
		if(head == null)
		{
			System.out.println("Linked list is empty"); return ;
		}
		MessageLink tmp = head;
		MessageLink refNode=null;
		while(tmp != null)
		{
			if(tmp.getMsg().equals(msgAfter)){
				refNode = tmp;
				break;
			
			}
			tmp = tmp.getNextMsgLink();
		}
		
		if(refNode != null)
		{
			MessageLink newMsgLnk = new MessageLink();
			newMsgLnk.setMsg(newMsg);
			
			newMsgLnk.setNextMsgLink(refNode.getNextMsgLink());
			refNode.setNextMsgLink(newMsgLnk);
		}
		else
		{
			System.out.println("Message not found ...");
		}
		traverse();
	}
	
	public void deleteParticuler(String msg)
	{
		MessageLink tmp = head;
		MessageLink prevNode = null;
		MessageLink refNode = null;
		if(tmp == null){
			System.out.println("Linked list is empty-");return;
		}
		else
		{
			while(tmp != null)
			{
				
				if(tmp.getMsg().equals(msg))
				{
					refNode = tmp;
					break;
				}
				prevNode = tmp;
				tmp = tmp.getNextMsgLink();
			}
			
			if(refNode == null)
			{
				System.out.println("Message not found ...");
			}
			else
			{
				if(head == refNode)
				{
					MessageLink newHead = head.getNextMsgLink();
					head = newHead;
				}
				else
				{
					prevNode.setNextMsgLink(tmp.getNextMsgLink());
				}
					
			}
		}
		traverse();
			
	}
	
	public void traverse()
	{
		MessageLink tmp = head;
		if(tmp ==null)
		{
			System.out.println("Linked list is empty-traverse");
		}
		else
		{
			while(tmp != null)
			{
				System.out.println(tmp.getMsg());
				tmp= tmp.getNextMsgLink();
				
			}
		}
	}
	
	public void deleteLink()
	{
		
	}
	
	
	
}

class MessageLink {
	
	String msg;
	MessageLink nextMsgLink;
	
	MessageLink(){}
	MessageLink(String msg, MessageLink nextMsgLink)
	{
		this.msg = msg;
		this.nextMsgLink = nextMsgLink;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public MessageLink getNextMsgLink() {
		return nextMsgLink;
	}
	public void setNextMsgLink(MessageLink nextMsgLink) {
		this.nextMsgLink = nextMsgLink;
	}
	
	
	
	
}
