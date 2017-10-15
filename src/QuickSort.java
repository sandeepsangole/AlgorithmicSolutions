
public class QuickSort {

		
	public static void main(String[] args) {
		
		QuickSort qs = new QuickSort();
		int[] unsortedArray = {8,5,10,4,2,6};
		qs.QuickSortList(unsortedArray,0,unsortedArray.length-1);
		
	}

	private static void QuickSortList(int[] array, int startIndex, int endIndex)
	{
		printArray(array);
		if(startIndex >= endIndex)
		{
			System.out.println("startIndex >= endIndex ..Exiting ");
			return;
		}
		
		int nextPIndex = partitionArray(array,startIndex,endIndex);
		
		System.out.println("nextPIndex : "+nextPIndex);
		QuickSortList(array,startIndex,nextPIndex-1);
		System.out.println("first QuickSortList : ");
		printArray(array);
		QuickSortList(array,nextPIndex +1,endIndex);
		System.out.println("Second QuickSortList : ");
		printArray(array);
		
	}
	
	private static int partitionArray(int[] array, int startIndex, int endIndex)
	{
		int pivot = array[endIndex];
		int pIndex =startIndex;
		for(int i =startIndex;i< endIndex ;i++)
		{
			if(array[i] <= pivot)
			{
				swap(array,i,pIndex);
				printArray(array);
				pIndex++;
			}
		}
		//printArray(array);
		//System.out.println("PIVOT : "+array[endIndex]);
		//System.out.println("pIndex : "+pIndex);
		swap(array,endIndex,pIndex);
		printArray(array);
		//System.out.println("PIVOT : "+array[endIndex]);
		//System.out.println("pIndex : "+pIndex);
		return pIndex;
	}
	
	private static void swap(int[] array,int index1,int index2)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private  static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");

		System.out.println("");
	}
}
