package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonAnagram {

	public void findIndex(String mainStr,String subStr) {

		List<Integer>           indexLst   = new ArrayList<Integer>();
		Map<Character, Integer> map        = new HashMap<Character, Integer>();
		int                     startIndex = 0;
		for (int i = 0; i < subStr.length(); i++) {
			char c = subStr.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

		}


		for (int i = 0; i < mainStr.length(); i++) {

			String windowStr = mainStr.substring(i, subStr.length());
			for (int j = 0; j < windowStr.length(); j++) {

			}

		}

	}


}
