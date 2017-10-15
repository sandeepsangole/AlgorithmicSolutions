
public class StackExample {


   
	int defaultLength = 10;
	int[] stackArray = new int[10];
	int top = -1;
	
	public static void main(String[] args) {
		StackExample s = new StackExample();
		s.insert(10);
		s.delete();
		s.delete();
		
	}
	
	private void insert(int no)
	{
		if(top == stackArray.length - 1)
		{
			System.out.println("Stack is full");
			return;
		}
		
		top++;
		stackArray[top] = no;
		System.out.println("Inserting..");
		print();
		
	}
	
	private void delete()
	{
		if(top ==-1)
		{
			print();
			System.out.println("Array is empty");
			return;
			
		}
		stackArray[top] = 0;
		top--;
		System.out.println("Deleting..");
		print();
	}
	
	private void print()
	{
		if(top ==-1)
		{
			System.out.println("Array is empty");
			return;
			
		}
		
		for (int i = 0; i < stackArray.length; i++)
			System.out.print(stackArray[i] + " ");

		System.out.println("");
		
	}
	
	

}
