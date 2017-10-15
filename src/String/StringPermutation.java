package String;

import java.util.*;

public class StringPermutation {

	public static void main(String args[]) {
		StringPermutation obj = new StringPermutation();
		//obj.permutations("aab");

		obj.combinations("ab");

	}

	public List<String> permutations(String str) {
		List<String> result = new ArrayList<String>();
		permutations("", str, result);

		System.out.println(result);
		return result;
	}

	public void permutations(String prefix, String str, List<String> result) {

		int len = str.length();
		if (len == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < len; i++) {
				//Looks for first occurance of char from given index
				if(str.indexOf(str.charAt(i),i+1) != -1)
					continue;
				permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len), result);
			}
		}

	}

	public void combinations(String str){
		combinations("",str);
	}
	public void combinations(String prefix,String str){
		System.out.println(prefix);
		for(int i=0;i<str.length();i++){
			combinations(prefix+str.charAt(i),str.substring(i+1,str.length()));
		}
	}

}
