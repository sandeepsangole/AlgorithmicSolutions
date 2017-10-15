package dp;

/**
 * Date 08/01/2014
 * @author Tushar Roy
 *
 * Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2)
 * Space complexity - O(n2
 *
 * Youtube link - https://youtu.be/_nCsPn7_OgI
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {

    public int calculate1(char []str){
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){ //level 2,3,4
            for(int i = 0; i < str.length-l + 1; i++){ //skip last characters equal to length to avoid index issue
                int j = i + l - 1; //1 + 2 -1 == 2 meaning processing 01 , 12 etc
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length-1];
    }

	//BBABCBCAB
    public int calculateRecursive(char str[],int start,int len){

      System.out.println("str :"+str + "Start : "+start +" len "+len );

        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }

	    if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{

            int first = calculateRecursive(str, start+1, len-1);
            int second = calculateRecursive(str, start, len-1);

            return Math.max(first,
                            second);
        }
    }


    public static void main(String args[]){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "BBABCBCAB";
       /* int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
        int r2 = lps.calculate1(str.toCharArray());
        System.out.print(r1 + " " + r2);
*/
	    System.out.print("--->"+lps.longestPalindromeSubseq(str));
    }

	public int longestPalindromeSubseq(String s) {
		return lps(s, 0, s.length() - 1);
	}

	private int lps(String s, int i, int j) {

		if (i > j)      return 0;

		if (i == j)     return 1;

		if (s.charAt(i) == s.charAt(j)) {
			return lps(s, i + 1, j - 1) + 2;
		} else {
			return Math.max(lps(s, i + 1, j),
								 lps(s, i, j - 1));
		}

	}

}
