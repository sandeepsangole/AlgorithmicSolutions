package Arrays;

import java.util.Map;
import java.util.HashMap;
//Given a list of integers.  Find two integers inside the list that add up to a target value

//4,5,6,8,1  target 11
public class FindPair {


	public static void main(String[] args) {

		int []a = {3,4,6,8,1};
		findPairs(a,11);

	}

	public static void findPairs(int[] input, int sum){

		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<input.length -1 ;i++){

			if(map.containsKey(input[i])){
				System.out.println("Pair Is "+input[i] +" "+map.get(input[i]));
				return;
			}
			else
			{
				map.put(sum - input[i],input[i]);
			}
		}



	}
}