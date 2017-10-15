package codejam;

import java.io.*;
import java.util.*;

public class PC {

	public static void main(String[] args) {

		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);

		Scanner in = null;
		try {
			in = new Scanner(inputFile);
		}
		catch (FileNotFoundException e_in) {
			e_in.printStackTrace();
		}

		FileWriter fWriter = null;
		try {
			fWriter = new FileWriter(outputFile);
		}
		catch (IOException e_out) {
			e_out.printStackTrace();
		}
		PrintWriter out = new PrintWriter(fWriter);

		int caseNumber = in.nextInt();
		System.out.println("Cases: " + caseNumber);

		for(int number = 1 ; number <=caseNumber; ++number) {
			in.nextLine();

			int n = in.nextInt(), q = in.nextInt(), ans = 0;
			in.nextLine();
			if(n == 1) {
				String s = in.nextLine(), t = in.nextLine();;
				int sc = in.nextInt(), common = 0;
				for(int i = 0; i < q; ++i) {
					if(s.charAt(i) == t.charAt(i))
						++common;
				}
				ans = Math.min(common, sc) + Math.min(q-common, q-sc);
			}
			else {
				String s1 = in.nextLine(), s2 = in.nextLine(), t = in.nextLine();
				int sc1 = in.nextInt(), sc2 = in.nextInt(), c1 = 0, c2 = 0, c = 0;
				for(int i = 0; i < q; ++i) {
					if(s1.charAt(i) == s2.charAt(i)) {
						if(t.charAt(i) == s1.charAt(i))
							++c;
					}
					else {
						if(t.charAt(i) == s1.charAt(i))
							++c1;
						else
							++c2;
					}
				}
				int samec = (sc1 + sc2 - c1 - c2)/2, d1c = sc1 - samec, d2c = sc2 - samec;
				ans += Math.min(d1c, c1) + Math.min(d2c, c2) + Math.min(samec, c) + Math.min(q-c1-c2-samec, q-c1-c2-c);
			}

			out.println("Case #" + number + ": " + ans);
		}

		in.close();

		out.close();

	}

}
