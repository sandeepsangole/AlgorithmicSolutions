import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

	public static void main(String args[]){
		//System.out.println(lengthOfLongestSubstring("ababc"));
		System.out.println(lengthOfLongestSubString1("abad"));
	}

	public static int lengthOfLongestSubstring(String s){
		int[] charMap = new int[256];
		Arrays.fill(charMap,-1);
		int i= 0, maxLen = 0;

		for(int j=0;j<s.length();j++){
			//System.out.println(Arrays.toString(charMap));
			//System.out.println(" J : "+j +" s.charAt(j) : "+s.charAt(j) +"  charMap[s.charAt(j)] : "+charMap[s.charAt(j)] +" i : "+i);
			if(charMap[s.charAt(j)] >= i){
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLen = Math.max(j-i+1,maxLen);
			System.out.println(Arrays.toString(charMap));
			//System.out.println(" maxLen :"+maxLen +" [s.charAt(j) : "+s.charAt(j) +" charMap[s.charAt(j)]   :"+charMap[s.charAt(j)]);
		}
		return maxLen;
	}

	public static int lengthOfLongestSubString1(String s){
		if(s == null || s.length() == 0)
			return 0;

		char[] arr = s.toCharArray();
		int prev = 0;
		//abad
		Map<Character , Integer> map = new HashMap<Character,Integer>();
		for(int i =0;i<arr.length;i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i],i);
			}
			else
			{
				prev = Math.max(prev,map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}
		return Math.max(prev,map.size());
	}
}
