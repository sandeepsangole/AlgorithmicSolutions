package personal.test;

import java.util.Arrays;

public class ReverseSentense {
	public static void main(String args[]) {
		ReverseSentense rev = new ReverseSentense();
		System.out.print(rev.reverseSentence("This is Sandeep"));
	}

	public String reverseSentence(String sentence) {
		String[] split = sentence.split("\\s");
		StringBuffer reverseString = new StringBuffer();
	for(int i = split.length - 1;i>= 0;i-- ) {
		reverseString.append(split[i]).append(" ");
	}
		return reverseString.toString().trim();
	}


}
