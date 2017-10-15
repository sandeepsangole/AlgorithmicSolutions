package Arrays;

public class FindMissing {

	public static void main(String args[]) {
		System.out.println(9 ^ 9);
		FindMissing obj  = new FindMissing();
		int[]       arr1 = { 9, 7, 8, 5, 4, 6, 2, 3, 1 };
		int[]       arr2 = { 2, 4, 3, 9, 1, 8, 5, 6 };
		obj.findMissingNumber(arr1, arr2);
	}

	public void findMissingNumber(int[] array1, int[] array2) {
		int result = array1[ 0 ];
		for (int i = 1; i < array1.length; i++) {
			result = result ^ array1[ i ];
		}
		for (int i = 0; i < array2.length; i++) {
			result = result ^ array2[ i ];
		}
		System.out.println("Missing element = " + result);
	}

}
