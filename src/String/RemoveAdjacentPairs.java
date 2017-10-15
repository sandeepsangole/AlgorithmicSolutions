package String;

public class RemoveAdjacentPairs {
	public static void main(String[] args) {
		RemoveAdjacentPairs obj = new RemoveAdjacentPairs();
		String              str = "ABCCBCBA";

		obj.removeAdj(str.toCharArray(), str.length() - 1);

	}
//ABCCBCBA
	public void removeAdj(char[] arr, int len) {
		int j = 0;
		for (int i = 1; i <= len; i++) {
		System.out.println(arr[ j ]+ "  " +arr[ i ]);
			while (arr[ i ] == arr[ j ] && j >=0 ) { //found paid
				i++;
				j--;
			}
		//System.out.println(arr[ ++j ]+ "  " +arr[ i ]);
			arr[++j] = arr[i];

		}

		System.out.println(arr);

		return;

	}

}
