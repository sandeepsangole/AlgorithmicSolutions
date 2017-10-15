
import java.util.*;

public class StringUtils {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>>                 result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map    = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			str = str.toLowerCase().replace(" ", "");
			char[] arr = new char[ 26 ];
			for (int i = 0; i < str.length(); i++) {
				arr[ str.charAt(i) - 'a' ]++;
			}
			String ns = new String(arr);
			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}
		result.addAll(map.values());
		return result;
	}

	public void reverseWords(char[] s) {
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[ j ] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
		reverse(s, i, s.length - 1);
		reverse(s, 0, s.length - 1);
	}

	public void reverse(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[ i ];
			s[ i ] = s[ j ];
			s[ j ] = temp;
			i++;
			j--;
		}
	}


	public boolean increasingTiplet(int[] num) {
		boolean exist = false;

		for (int i = 2; i < num.length; i++) {
			if (num[ i ] == (num[ i - 1 ] + 1) && num[ i ] == (num[ i - 2 ]) + 2) {
				return true;
			}
		}

		return exist;
	}

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k == 0 || s == null || s.length() == 0)
			return 0;
		if (s.length() < k)
			return s.length();
		HashMap<Character, Integer> map    = new HashMap<Character, Integer>();
		int                         maxLen = k;
		int                         left   = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			if (map.size() > k) {
				maxLen = Math.max(maxLen, i - left);
				while (map.size() > k) {
					char fc = s.charAt(left);
					if (map.get(fc) == 1) {
						map.remove(fc);
					} else {
						map.put(fc, map.get(fc) - 1);
					}
					left++;
				}
			}
		}
		maxLen = Math.max(maxLen, s.length() - left);
		return maxLen;
	}




	//abcbbbbb
	public int findContinuousNonRepeatingStringLength(String str) {

		if (str == null)
			return 0;

		char[]                  arr  = str.toCharArray();
		Map<Character, Integer> map  = new HashMap<Character, Integer>();
		int                     prev = 0;
		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(arr[ i ])) {
				map.put(arr[ i ], i);
			} else {
				prev = Math.max(prev, map.size());
				i = map.get(arr[ i ]);
				map.clear();
			}
		}

		System.out.println("Output : " + Math.max(prev, map.size()));
		return Math.max(prev, map.size());


	}

	public static void main(String args[]) {
		StringUtils strUtils = new StringUtils();
		//strUtils.findContinuousNonRepeatingStringLength("aabbccdda");
		//	System.out.println(strUtils.increasingTiplet(new int[] { 1, 2, 3, 4, 5 }));
		//System.out.println(strUtils.increasingTiplet(new int[] { 1, 4, 5, 6, 6, 7 }));
		//strUtils.reverseWords(new char[] { 't', 'h', 'e', ' ', 'b', 'o', 'o', 'k' });
		//strUtils.groupAnagrams(new String[] { "Torchwood", "Dockor Who" });

		//System.out.println(strUtils.lengthOfLongestSubstringKDistinct("abbcadaabbb",2));
		System.out.println(strUtils.minWindow("DARBTACBC","ABC"));
	}

	//Given a string S and a String T find the minimum windiw in S which will contain all the chrCTERS in T in complexity 0(n)
	public String minWindow(String s, String t) {
		if(t.length()>s.length())
			return "";
		String result = "";

		//character counter for t
		HashMap<Character, Integer> target = new HashMap<Character, Integer>();
		for(int i=0; i<t.length(); i++){
			char c = t.charAt(i);
			if(target.containsKey(c)){
				target.put(c,target.get(c)+1);
			}else{
				target.put(c,1);
			}
		}

		// character counter for s
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int minLen = s.length()+1;

		int count = 0; // the total of mapped characters

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);

			if(target.containsKey(c)){
				if(map.containsKey(c)){
					if(map.get(c)<target.get(c)){
						count++;
					}
					map.put(c,map.get(c)+1);
				}else{
					map.put(c,1);
					count++;
				}
			}

			for(Map.Entry entry : map.entrySet()){
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}

			if(count == t.length()){
				char sc = s.charAt(left);
				while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
					if (map.containsKey(sc) && map.get(sc) > target.get(sc))
						map.put(sc, map.get(sc) - 1);
					left++;
					sc = s.charAt(left);
				}

				if (i - left + 1 < minLen) {
					result = s.substring(left, i + 1);
					minLen = i - left + 1;
				}
			}
		}

		return result;
	}
}