package hackerrank;


import java.io.*;
		import java.util.*;
		import java.text.*;
		import java.math.*;
		import java.util.regex.*;

public class BankTransfer {

	static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
		int total =0;
		for(int pi:p){
			total = total + Math.max(k,(pi * 10)/100);
		}
		if(total > d){
			return "upfront";
		}

		return "fee";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int k = in.nextInt();
			int x = in.nextInt();
			int d = in.nextInt();
			int[] p = new int[n];
			for(int p_i = 0; p_i < n; p_i++){
				p[p_i] = in.nextInt();
			}
			String result = feeOrUpfront(n, k, x, d, p);
			System.out.println(result);
		}
		in.close();
	}
}

