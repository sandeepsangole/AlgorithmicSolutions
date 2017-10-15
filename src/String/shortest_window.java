package String;

import java.util.*;

public class shortest_window {

	public static void main(String[] args) {

		String word = "ADOBECODEBANC";

		String target = "ABC";

		System.out.println(solution(word, target));

	}

	public static String solution(String word, String targ) {

		if (word == null || word.length() < 1) return "";

		if (targ == null || targ.length() < 1) return "";


		char[] arr = targ.toCharArray();

		String shortest = word;

		for (int i = 0; i < word.length(); i++) {

			String temp = "";

			ArrayList<Character> target = new ArrayList<Character>();

			for (Character c : arr) {
					target.add((Character) c);

			}

			for (int j = i; j < word.length(); j++) {

				Character a = (Character) word.charAt(j);

				temp += a;

				if (target.contains(a)) {

					target.remove(a);

				}


				if (target.size() == 0) {

					if (shortest.length() > temp.length()) shortest = temp;

					break;

				}

			}

		}

		return shortest;

	}

}

