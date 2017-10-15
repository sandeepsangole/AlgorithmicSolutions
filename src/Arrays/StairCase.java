package Arrays;

import java.util.HashSet;

public class StairCase {
	int n = 4;

	public static void main(String args[]){
		int n = 6;int space=n-1;int hash=1;
		buildStairCase(n,space,hash);
	}

	static int buildStairCase(int n, int space, int hash){

			if(n <=0 )
				return 0;

			for(int i =0;i<space;i++){
				System.out.print(" ");

			}
			for(int j =0;j<hash;j++){
				System.out.print("#");

			}

		hash++;space--;n--;

		System.out.println();
		return buildStairCase(n--,space--,hash++);

	}

	public int consecutive(int[] a){
		HashSet<Integer> values = new HashSet<Integer>();
		for(int i : a){
			values.add(i);
		}

		int max = 0;
		for(int i : values){
			if(values.contains(i-1)) continue;

			int length = 0;
			while(values.contains(i++)) length ++;
			max = Math.max(max, length);

		}
		return max;
	}
}
