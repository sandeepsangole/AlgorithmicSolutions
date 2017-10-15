
public class InsertionSort {

	int[] array = {  14, 5, 8 };

	public static void main(String[] args) {

		InsertionSort sort = new InsertionSort();
		sort.insertionSort();

	}

	private void insertionSort() {
		printArray();
		for (int m = 0; m < array.length; m++) {

			for (int j = m, i = m; j >= 0;) {
				
				j--;
				System.out.println("  m: "+m +"  j: "+j+"  i: "+i);
				if (j >= 0) {
					if (array[j] > array[i]) {
						swap(i, j);
						printArray();
						i--;
					}
				}

			}

		}
		printArray();
	}

	void printArray() {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");

		System.out.println("");
	}

	private void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

	}
}
