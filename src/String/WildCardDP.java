package String;

/*
23.Wildcard Matching
Implement wildcard pattern matching with support for ’?’ and ’*’.
*/

import java.util.*;

public class WildCardDP{

	public static void main(String args[]){
		WildCardDP obj = new WildCardDP();
		System.out.println(obj.matchStrings("aab","*d"));
	}

	public boolean  matchStrings(String s,String p){

		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();

		boolean isMatching = false;

		boolean[][] matrix = new boolean[str.length][pattern.length];

		if(pattern.length > 0 && pattern[0] == '*'){
			matrix[0][1]=true;
		}

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