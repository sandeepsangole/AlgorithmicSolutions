

public class CircularQueue {

    int front =-1;
    int rear = -1;
	int[] carray = new int[10];
	public static void main(String[] args) {
		
		CircularQueue cq = new CircularQueue();
		cq.insertInCircularQueue(1);
		cq.insertInCircularQueue(2);
		cq.insertInCircularQueue(3);
		cq.insertInCircularQueue(4);
		cq.insertInCircularQueue(5);
		
		cq.deleteFromCircularQueue();
		
		cq.insertInCircularQueue(6);
		cq.insertInCircularQueue(7);
		cq.insertInCircularQueue(8);
		
		cq.deleteFromCircularQueue();
		cq.deleteFromCircularQueue();
		
		cq.insertInCircularQueue(9);
		cq.insertInCircularQueue(10);
		cq.insertInCircularQueue(11);
		System.out.println("Front "+cq.front);
		System.out.println("REAR "+cq.rear);
		
		cq.deleteFromCircularQueue();
		
		cq.insertInCircularQueue(12);
		cq.insertInCircularQueue(13);
		
		cq.insertInCircularQueue(14);
		
		System.out.println("Front "+cq.front);
		System.out.println("REAR "+cq.rear);
		
		cq.insertInCircularQueue(15);
	}

	private  void insertInCircularQueue(int no)
	{
		print();
		
		if(front == -1 && rear ==-1)
		{
			front++;
			rear ++;
			carray[rear] = no;
			
		}
		else if(((rear+1) % carray.length) == front)
		{
			System.out.println("Queue is full");
		}
		else
		{	rear = (rear+1) % carray.length;
			carray[rear] = no;
		}
		print();
	}
	
	private  void deleteFromCircularQueue()
	{
		print();
		if(front == -1)
		{
			System.out.println("Queue is empty");
			return;
			
		}
		else if(front == rear)
		{
			front = -1;
			rear  = -1;
			carray[front] = 0;
		}
		else 
		{
			carray[front] = 0;
			front =(front + 1)%carray.length;
			
		}
		print();
	}
	
	private void print()
	{
		if(front ==-1 && rear == -1)
		{
			System.out.println("Queue is empty");
			return;
			
		}
		
		for (int i = 0; i < carray.length; i++)
			System.out.print(carray[i] + " ");

		System.out.println("");
		
	}
}
