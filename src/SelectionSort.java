
public class SelectionSort {

	 int[] arry = {30,1,5,3,4,11,76};
	 int baseIndex;
	 int swapIndex;
	 int minValue;
	private void sortMe()
	{
		printArray();
		for(int i =0;i< arry.length -1 ;i++)
		{
			
			baseIndex = i;
			swapIndex = 0;
			minValue = arry[i];
			for(int j =i ;j< arry.length-1;j++)
			{
				if(minValue > arry[j+1])
				{
					swapIndex = j+1;
					minValue = arry[j+1];
				
				}
			}
			if(swapIndex > 0)
			swapIndex(baseIndex ,swapIndex);
			printArray();
		}
	}
	
	private void swapIndex(int index1,int index2)
	{
		int temp = arry[index1];
		arry[index1] = arry[index2];
		arry[index2] = temp;
	}
	

	void printArray() {
			for (int i = 0; i < arry.length; i++)
				System.out.print(arry[i] + " ");

			System.out.println("");
		}
	
	
	public static void main(String[] args) {
		SelectionSort s = new SelectionSort();
		s.sortMe();
	}

}
