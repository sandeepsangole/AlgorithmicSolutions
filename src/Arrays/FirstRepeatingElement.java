package Arrays;
import java.util.*;

public class FirstRepeatingElement {

	public static void main(String[] args) {
		System.out.println(printFirstRepeating(new int[]{3,2,1,2,2,3,15}));
	//	System.out.println(findFirstRepeatedNumber(new int[]{3,2,1,2,2,3,16}));

		//System.out.println(findOddNumberOfTimes(new int[]{1,2,3,2,3,1,3}));

	}
//doesnt work
	public static int findFirstRepeatedNumber(int[] arr){

	int result = 0;
		int[] temp = new int[arr.length];

		for(int i = 0;i<arr.length;i++){
			temp[arr[i]]++;
		}

		for(int i = 0;i<arr.length;i++){
			if(temp[arr[i]] > 1)
				result =  arr[i];
			break;
		}
		return result;
	}

	public static int printFirstRepeating(int[] arr){

		int min = -1;

		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = arr.length - 1;i>=0;i--){

			if(set.contains(arr[i])){
				min = i ;
			}
			else
			{
				set.add(arr[i]);
			}
		}

		if(min != -1){
			return arr[min];
		}
		else
			return 0;

	}

	public static int findOddNumberOfTimes(int[] arr){
		int temp = 0;
		for(int i =0 ;i<arr.length;i++){
			 temp =temp ^ arr[i];
		}
		return temp;
	}
}
