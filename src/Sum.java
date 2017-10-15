
import java.util.*;

public class Sum {

	public static void main(String[] args) {
		Sum obj = new Sum();
		//obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.print(obj.hammingWeight(11));
	}

	public int getSum(int a, int b) {
		while (b != 0) {
			int c = a & b;
			a = a ^ b;
			b = c << 1;
		}
		return a;
	}

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		int          len    = s.length();
		if (len < 10) {
			return result;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		Set<Integer> temp  = new HashSet<Integer>();
		Set<Integer> added = new HashSet<Integer>();
		int          hash  = 0;
		for (int i = 0; i < len; i++) {
			if (i < 9) {
				//each ACGT fit 2 bits, so left shift 2
				hash = (hash << 2) + map.get(s.charAt(i));
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				//make length of hash to be 20
				hash = hash & (1 << 20) - 1;
				if (temp.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash); //track added
				} else {
					temp.add(hash);
				}
			}
		}
		return result;
	}


	public int hammingWeight(int n) {
		int count = 0;
		for (int i = 1; i < 33; i++) {
			if (getBit(n, i) == true) {
				count++;
			}
		}
		return count;
	}

	public boolean getBit(int n, int i) {
		return (n & (1 << i)) != 0;
	}


}
