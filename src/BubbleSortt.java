
public class BubbleSortt {

	private int[] nostoSort = new int[5];

	int[] generateRandomArray() {
		for (int i = 0; i < 5; i++) {
			nostoSort[i] = (int) (Math.random() * 10) + 10;
		}
		return nostoSort;
	}

	void swapValues(int val1, int val2) {
		int temp = nostoSort[val1];
		nostoSort[val1] = nostoSort[val2];
		nostoSort[val2] = temp;
	}

	public void bubbleSort() {
		for (int i = nostoSort.length - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (nostoSort[j] > nostoSort[j + 1]) {
					swapValues(j, j + 1);
					printArray();
				}
			}
		}
	}

	void printArray() {
		for (int i = 0; i < nostoSort.length; i++)
			System.out.print(nostoSort[i] + " ");

		System.out.println("");
	}

	public static void main(String[] args) {
		BubbleSortt bs = new BubbleSortt();
		bs.generateRandomArray();
		bs.printArray();
		bs.bubbleSort();
	}
	
	/*
	
	int[] arry = {123 ,6 ,19,5,8,1};

	
	
	public void bubbleSorta() {
		
		for(int i = arry.length -1;i > 1;i--)
		{
			for(int j = 0; j< i;j++)
			{
				if(arry[j] > arry[j+1])
				{
					swap(j,j+1);
				}
			}
		}
	} */

}
