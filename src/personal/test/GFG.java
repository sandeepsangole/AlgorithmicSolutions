package personal.test;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Find Anagrams
 */
class GFG {
	public static void main (String[] args) {
		GFG obj  = new GFG();
		obj.permutation("AAB");
	}
	
	public void permutation(String str)
	{
	    findAnagrams("",str);
	}
	
	private void findAnagrams(String per,String word)
	{
	    if(word.isEmpty())
	    {
	        System.out.println(per);
	    }
	    else
	    {
	        for(int i=0;i<word.length();i++){
	            findAnagrams(per+word.charAt(i),word.substring(0,i)+word.substring(i+1,word.length()));
	        }
	    }
	    
	}
}