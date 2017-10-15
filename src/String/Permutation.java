package String;


import java.util.*;

public class Permutation {

	public static void main(String args[]){
		Permutation obj = new Permutation();
		obj.findPermutations("abc");
	}
	public void findPermutations(String str) {

		List<String> lst = new ArrayList<String>();
		findPermutations("",str, lst);
		System.out.println(lst);
	}

	private void findPermutations(String prefix, String str, List<String> lst) {

		int len = str.length();

		if (len == 0) {
			lst.add(prefix);
		return;
		}

		for (int i = 0; i < len; i++) {

			System.out.println("str-->"+str);
			char   c      = str.charAt(i);
			String before = str.substring(0, i);
			String after  = str.substring(i + 1, len);

			if((str.indexOf(c,i+1)) != -1)
			continue;

			findPermutations(prefix + c, before + after, lst);
		}

	}
}