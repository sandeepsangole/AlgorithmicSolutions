
public class QueueExample {
	
	int front=-1,rear = -1;
	static int[] queueArray = new int[10];
	
	public static void main(String args[])
	{
				QueueExample q = new QueueExample();
				q.insertInQueue(5);
				q.insertInQueue(10);
				q.insertInQueue(15);
				q.insertInQueue(20);
				q.deleteFromQueue();q.insertInQueue(99);
				q.deleteFromQueue();
				q.deleteFromQueue();
				q.deleteFromQueue();
				q.insertInQueue(11);
				q.insertInQueue(12);
				q.insertInQueue(13);
				q.insertInQueue(14);
				q.insertInQueue(15);
				q.insertInQueue(16);
				q.deleteFromQueue();
				q.deleteFromQueue();
				q.deleteFromQueue();
				
				q.insertInQueue(4);
				
				
	}
	
	private void insertInQueue(int no)
	{
		if(rear >= queueArray.length -1)
		{
			System.out.println("Queue is full");
			return;
		}
		if(front ==-1 && rear == -1)
		{
			front++;
			rear++;
			queueArray[rear] = no;
		}
		else
		{
			rear++;
			queueArray[rear] = no;
		}
		System.out.println("Inserting in queue..");
		print();
		
	}
	private void deleteFromQueue()
	{
		if(front == -1)
		{
			System.out.println("Queue is empty");
			return;
		}
		if(front == rear)
		{
			front = -1;
			rear = -1;
		}
		else
		{
			queueArray[front] = 0;
			front++;
		}
		System.out.println("Deleting from Queue ...");
		print();
		
	}
	
	private void print()
	{
		if(front ==-1 && rear == -1)
		{
			System.out.println("Queue is empty");
			return;
			
		}
		
		for (int i = 0; i < queueArray.length; i++)
			System.out.print(queueArray[i] + " ");

		System.out.println("");
		
	}

}
