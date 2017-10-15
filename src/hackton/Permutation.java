package hackton;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		int[] array = { 1,2,3,4,5,6,7,8,9,10,11,12};
		int k = 2;
		ArrayList<int[]> arrayLst = new ArrayList<int[]>();
		
		permutation(array, 0, arrayLst);
		boolean allMatch = false;
		int[] arr = null;
		for (int i = 0; i < arrayLst.size(); i++) {
			arr = arrayLst.get(i);
			int count = 0;

			for (int j = 0; j < arr.length; j++) {
				if (Math.abs(arr[j] - array[j]) == k) {
					count++;

				}

			}
			if(count == arr.length)
			{
				printArray(arr);
				allMatch = true;
				break;
			}

		}
		if(!allMatch)
		System.out.println("-1");

	}

	static void printArray(int[] arr) {
		if (arr != null) {
			for (int f = 0; f < arr.length; f++) {
				System.out.print(arr[f] + " ");

			}
		}
	}

	/*static ArrayList<int[]> permutations(int[] a) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		permutation(a, 0, ret);
		return ret;
	}*/

	public static void permutation(int[] arr, int pos, ArrayList<int[]> list) {
		if (arr.length - pos == 1)
			list.add(arr.clone());
		else
			for (int i = pos; i < arr.length; i++) {
				swap(arr, pos, i);
				permutation(arr, pos + 1, list);
				swap(arr, pos, i);
			}
	}

	public static void swap(int[] arr, int pos1, int pos2) {
		int h = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = h;
	}
}
