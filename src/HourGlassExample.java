
public class HourGlassExample {

	public static void main(String[] args) {
		int a [][] = new int[6][6];
		System.out.println(args.toString());
		int index = 0;
		
		
		for (int i=0;i<6;i++)  
	     {  
	       for(int j =0 ;j<6;j++)  
	       {  
	         a[i][j] = Integer.parseInt(args[index]);
	         index++;
	       }  
	         
	     }  
		printHourGlasses(a);
		
	}
	
	/*
	1 1 1 0 0 0
	0 1 0 0 0 0
	1 1 1 0 0 0
	
	0 0 2 4 4 0
	0 0 0 2 0 0
	0 0 1 2 4 0
	*/
	
	public static void printHourGlasses(int a[][])
	{
		int maxSum = 0;
		
		for(int i=0;i< 4 ;i++)
		{
			for(int j=0;j< 4;j++)
			{
				
				int total =	a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] +a[i+2][j+1] + a[i+2][j+2];
				
				if(maxSum == 0)
					maxSum = total;
				else if(maxSum < total)
				{
					maxSum = total;
				}
				
				/*System.out.println();
				
				System.out.print(a[i][j] +" " +a[i][j+1] +" "+a[i][j+2]);
				System.out.print("       "+a[i+1][j+1]+"    ");
				System.out.print(a[i+2][j] +" " +a[i+2][j+1] +" "+a[i+2][j+2]);
				System.out.println();*/
				
				
			}
			
		}
		System.out.println("Max Sum : "+maxSum);
	}

}
