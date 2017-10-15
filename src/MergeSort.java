
public class MergeSort {

	static int[] array = {3,6,7,1};
	public static void main(String[] args) {
		MergeSort mSort = new MergeSort();
		mSort.merge(array);

	}

	private static void merge(int[] array)
	{
		System.out.print("Merge Metohd start :");printArray(array);
		int arrayLengh = array.length;
		if(arrayLengh < 2)
		{
			return;
		}
		
		int count=0;
		int[] leftArray = new int[arrayLengh/2];
		int[] rightArray = new int[array.length - arrayLengh/2];
		for(int i =0;i<arrayLengh/2;i++)
		{
			leftArray[i] = array[i];
		}
		for(int j =arrayLengh/2;j<arrayLengh;j++)
		{
			rightArray[count] = array[j];
			count++;
		}
		
		
		System.out.print("Merge Method Left Array : ");
		printArray(leftArray);
		System.out.print("Merge Method Right Array : ");
		printArray(rightArray);
		merge(leftArray);
		merge(rightArray);	
		MergeLeftRightArray(array,leftArray,rightArray);
		System.out.print("Meger Method Last -- Original Array : ");
		printArray(array);
	}
	
	private static void MergeLeftRightArray(int[] original,int[] left , int right[])
	{
		System.out.println("STARTTT Inside MergeLeftRightArray :");
		System.out.print("orignal Array :");printArray(original);
		System.out.print("left Array :");printArray(left);
		System.out.print("right Array :");printArray(right);
		
		int leftIndex = 0,rightIndex= 0,originalIndex =0;
		while(leftIndex < left.length  && rightIndex < right.length)
		{	
			if(left[leftIndex] < right[rightIndex])
			{
				original[originalIndex] = left[leftIndex];
				originalIndex++;
				leftIndex++;
			}
			else
			{
				original[originalIndex] = right[rightIndex];
				originalIndex++;
				rightIndex++;
			}
		}
		
		while(leftIndex < left.length)
		{
			original[originalIndex] = left[leftIndex];
			originalIndex++;
			leftIndex++;
			
		}
		
		while(rightIndex < right.length)
		{
			original[originalIndex] = right[rightIndex];
			originalIndex++;
			rightIndex++;
		}
		
		System.out.println("ENDDDD Inside MergeLeftRightArray :");
		System.out.print("orignal Array :");printArray(original);
		System.out.print("left Array :");printArray(left);
		System.out.print("right Array :");printArray(right);
		
	}
	
	private static void printArray(int[] nostoSort) {
		for (int i = 0; i < nostoSort.length; i++)
			System.out.print(nostoSort[i] + " ");

		System.out.println("");
	}
}


