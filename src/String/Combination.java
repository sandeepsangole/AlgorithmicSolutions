package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
	public static void main(String[] args) {
		String       input = "ABC";
		StringBuffer sb    = new StringBuffer();
		combination(input.toCharArray(), 0, input.length() - 1, sb);

		System.out.println();
		System.out.println();
		System.out.println();
		List<String> res = new ArrayList<String>();

		permutations("", input, res);
		System.out.println(Arrays.asList(res));

		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));

		System.out.println(Arrays.toString(moveZeros(new int[]{0,1,0,3,2})));
	}

	public static void combination(char[] arr, int a, int b, StringBuffer sb) {
		//System.out.println("sb " + sb.toString() + " a : " + a + " b :" + b);
		for (int i = a; i <= b; i++) {
			sb.append(arr[ i ]);
			System.out.println(sb);
			combination(arr, i + 1, b, sb);
			sb.setLength(sb.length() - 1);
		}
	}

	public static void permutations(String prefix, String str, List<String> result) {

		int len = str.length();
		if (len == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < len; i++) {
				//Looks for first occurance of char from given index
				if (str.indexOf(str.charAt(i), i + 1) != -1)
					continue;
				permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len), result);
			}
		}

	}

	public static int[] moveZeros(int [] arr){

		if(arr == null || arr.length == 0){
			return null;
		}
		int i =0;
		int j = i + 1;
		while(j < arr.length){

			if(arr[i] == 0 && arr[j] != 0){
				arr[i] = arr[j];

			}

			j++;
		}
		int [] temp = Arrays.copyOf(arr,i+1);
		return temp;

	}


	public static int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;
		int prev = 1; // point to previous
		int curr = 2; // point to current
		while (curr < A.length) {
			if (A[ curr ] == A[ prev ] && A[ curr ] == A[ prev - 1 ]) {
				curr++;
			} else {
				prev++;
				A[ prev ] = A[ curr ];
				curr++;
			}
		}
		return prev + 1;
	}

}
