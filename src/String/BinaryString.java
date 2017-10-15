package String;

import java.util.PriorityQueue;

public class BinaryString {

	static int getMaxMonsters(int n, int hit, int t, int[] h){

		if(n == 0 || hit ==0 || t ==0){
			return 0;
		}

		int count = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i : h){
			if(i > 0)
			pq.offer(i);
		}

		while(!pq.isEmpty() && t > 0){
			int no = pq.remove();
			t--;
			int temp = no - hit;
			if(temp <= 0){
				count++;
			}
			else {
				pq.offer(temp);
			}
		}
		return count;

	}


	public static void main(String args[]){
		BinaryString obj = new BinaryString();
		/*duplicates(2);
		duplicates(5);
		duplicates(7);*/

		System.out.println(getMaxMonsters(7,8,6 ,new int[]{16,19,7,11,23,8,16}));
	}

	public static String duplicates(int x){

		String result = generateBinaryString(new StringBuilder("0"), new StringBuilder());
		System.out.println(result.charAt(x));
		return String.valueOf(result.charAt(x));
	}



	public static String generateBinaryString(StringBuilder str,StringBuilder t){

		if(str == null){
			return null;
		}

		if(str.length() > 1000){
			return str.toString();
		}

		for(int i=0;i<str.length();i++){
			t.append(str.charAt(i) == '1' ? '0' : '1');
		}

		str = str.append(t);
		t.setLength(0);
		return generateBinaryString(str,t).toString();
	}
}
