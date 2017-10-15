package Arrays;

/*
23.Wildcard Matching
Implement wildcard pattern matching with support for ’?’ and ’*’.
*/

public class WildCardMatrix{

	public static void main(String args[]){
		WildCardMatrix obj = new WildCardMatrix();
		System.out.println(obj.matchStrings("aab","*b"));
	}

	public boolean  matchStrings(String s,String p){

		//Convert String and Pattern in char Array
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();

		boolean isMatching = false;

		//Build Matrix - default all false
		boolean[][] matrix = new boolean[str.length + 1][pattern.length + 1];

		//If first pattern char is * then set matrix[0][1] to true
		if(pattern.length > 0 && pattern[0] == '*'){
			matrix[0][1]=true;
		}

		//by default first cell is true
		matrix[0][0]=true;

		for(int i =1;i<matrix.length;i++){
			for(int j =1;j<matrix[0].length;j++){
				if(pattern[j - 1] == '?' || pattern[j - 1] == str[i - 1])
					matrix[i][j] = matrix[i-1][j-1];
				else if(pattern[j - 1] == '*')
					matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];

			}
		}

		return matrix[str.length ][pattern.length];
	}
}