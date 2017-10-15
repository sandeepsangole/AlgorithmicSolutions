package codejam;
import java.util.*;
import java.io.*;

public class DiwliLights {

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
			String s = in.next();
			long    i = in.nextLong();
			long    j = in.nextLong();
			System.out.println("Case #" + c + ": " +(countBlueBulbs(s,j) - countBlueBulbs(s,i-1)));
		}

	}

 public static long countBlueBulbs(String pattern , long pointer){

	  long bCounter = 0;
	  for(int i = 0; i < pattern.length();i++){
		  if(pattern.charAt(i) == 'B'){
			  bCounter++;
		  }
	  }

	  long len = pattern.length();
	  long count = pointer/len;
	  long total = count * bCounter;

	  long remaining = pointer % len;
		for(int i =0;i<remaining;i++){
			if(pattern.charAt(i) == 'B') {
				total+=1;
			}
		}

		return total;

  }


}
