package codejam.sandy;

import java.io.*;
import java.util.Scanner;

public class MagicThinking {

	public static void main(String args[]){

		File in = new File(args[0]);
		File out = new File(args[1]);
		int res =0;
		Scanner scan = null;
		try{
			scan = new Scanner(in);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		FileWriter fWriter = null;
		try {
			fWriter = new FileWriter(out);
		}catch(IOException e){
			e.printStackTrace();
		}

		PrintWriter o = new PrintWriter(fWriter);
		System.out.println("No of test Cases : ");
		int cases = scan.nextInt();


		for(int i =1;i<=cases;i++){

			int n = scan.nextInt();
			int q = scan.nextInt();

			if(n == 1){

				String s = scan.next();
				String t = scan.next();
				int score = scan.nextInt();

				int common = 0;
				for(int p =0;p<q;p++){
					if(s.charAt(p) == t.charAt(p)){
						common++;
					}
				}

				res = Math.min(score,common) + Math.min(q-common,q-score);
				System.out.println("Case #" + i + ": " + res);



			}else{

			}
			o.println("Case #" + i + ": " + res);
		}

		scan.close();

		o.close();


	}
}
