package codejam;

import java.io.*;
import java.util.*;

public class PA {

	public static void main(String[] args) {

		File inputFile  = new File(args[ 0 ]);
		File outputFile = new File(args[ 1 ]);

		Scanner in = null;
		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e_in) {
			e_in.printStackTrace();
		}

		FileWriter fWriter = null;
		try {
			fWriter = new FileWriter(outputFile);
		} catch (IOException e_out) {
			e_out.printStackTrace();
		}
		PrintWriter out = new PrintWriter(fWriter);

		int caseNumber = in.nextInt();
		System.out.println("Cases: " + caseNumber);

		in.nextLine();

		for (int number = 1; number <= caseNumber; ++number) {

			String s = in.nextLine();
			if (s.length() % 2 == 1) out.println("Case #" + number + ": AMBIGUOUS");
			else {
				int    n      = s.length(), pre = 0;
				char[] encode = new char[ n ];
				System.out.println(n + " " + encode);

				for (int i = 0; i < n; i += 2) {
					System.out.println(s.charAt(i) - 'A' - pre + 26 + " : " + pre);
					pre = (s.charAt(i) - 'A' - pre + 26) % 26;
					System.out.println(s.charAt(i) - 'A' - pre + 26 + " : " + pre); //+ s.charAt(i) - 'A');
					encode[ i + 1 ] = (char) ('A' + pre);
				}
				pre = 0;
				for (int i = n - 1; i > 0; i -= 2) {
					pre = (s.charAt(i) - 'A' - pre + 26) % 26;
					encode[ i - 1 ] = (char) ('A' + pre);
				}
				out.println("Case #" + number + ": " + String.valueOf(encode));
			}
		}

		in.close();

		out.close();

}

}

