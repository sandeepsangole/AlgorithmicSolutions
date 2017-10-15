package cracking.coding;

public class UniqueCharacters {

	public static void main(String[] args){
		UniqueCharacters obj = new UniqueCharacters();
		System.out.println(obj.isUniqueueCharacters("Sandep"));
		System.out.println(obj.isOneEditDistance("pale","patr"));
	}

	public boolean isUniqueueCharacters(String str){

		if(str.length() > 128) return false;//Means has duplicate
		boolean[] charSet = new boolean[128];

		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			if(charSet[val]){
				return false;
			}else{
				charSet[val] = true;
			}
		}

		return true;

	}

	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null)
			return false;

		int m = s.length();
		int n = t.length();

		//If difference is more than one return false
		if (Math.abs(m - n) > 1) {
			return false;
		}

		int i     = 0;//length of string1
		int j     = 0; //length of string2
		int count = 0; //Keeps current edit distance

		while (i < m && j < n) {
			//If same
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				//if count >1 - return - no need to continue
				count++;
				if (count > 1)
					return false;

				if (m > n) {
					i++;
				} else if (m < n) {
					j++;
				} else {
					i++;
					j++;
				}
			}
		}

		//If lenth is not same
		if (i < m || j < n) {
			count++;
		}

		if (count == 1)
			return true;

		return false;
	}

}
