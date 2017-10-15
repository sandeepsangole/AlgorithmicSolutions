package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class TaskA {

	public static void main(String[] args) {

		PrintStream o = null;
		try {
			// Creating a File object that represents the disk file.
			o = new PrintStream(new File("A.txt"));
		}
		catch(Exception e){

		}
		// Store current System.out before assigning a new value
		PrintStream console = System.out;

		// Assign o to output stream
		System.setOut(o);

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int     t  = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int c = 1; c <= t; ++c) {
			//String s = in.next();
			long    n = in.nextLong();
			long    q = in.nextLong();

			while (n <= 0){



			}

			//System.out.println("Case #" + c + ": " +(countBlueBulbs(s,j) - countBlueBulbs(s,i-1)));
		}

	}


}
