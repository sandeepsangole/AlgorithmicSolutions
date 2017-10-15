package codejam;

/*
We consider a number to be beautiful if it consists only of the digit 1 repeated one or more times.
Not all numbers are beautiful, but we can make any base 10
positive integer beautiful by writing it in another base.

Given an integer N, can you find a base B (with B > 1) to write it in such that all of its digits become 1?
If there are multiple bases that satisfy this property, choose the one that maximizes the number of 1 digits.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case
consists of one line with an integer N.

Output
For each test case, output one line containing Case #x: y, where x is the test case
number (starting from 1) and y is the base described in the problem statement.



 */

import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) {
		System.out.println(Math.log(1));
		System.out.println(Math.log(2));
		System.out.println(Math.log(3));
		System.out.println(Math.log(4));
		System.out.println(Math.log(5));
		System.out.println(Math.log(6));
		System.out.println(Math.log(7));
		System.out.println(Math.log(8));
		System.out.println(Math.log(9));
		System.out.println(Math.log(10));

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int     t  = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			long n   = in.nextLong();
			long ans = n - 1;
			for (long j = 2; j < n - 1; j++) {
				long power     = 1;
				long candidate = 0;
				int  max       = (int) Math.floor(Math.log(n) / Math.log(j));
				for (int k = 0; k <= max; k++) {
					candidate += power;
					power *= j;
				}
				if (candidate == n) {
					ans = j;
					break;
				}
			}
			System.out.println("Case #" + i + ": " + ans);
		}
		in.close();
	}
}
