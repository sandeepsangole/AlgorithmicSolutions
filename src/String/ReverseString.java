package String;


import java.util.*;

public class ReverseString{

	public static void main(String args[]){
		ReverseString obj = new ReverseString();
		System.out.println(obj.reverseString("tesk"));

		obj.isZeroOddTimes(new int[] {0,1,2,2,1,0});

	}


	public void isZeroOddTimes(int[] arr){
		int result = 0;

		for(int i :arr){
			result = result ^ i;
		}

		System.out.println(result);
	}
	public String reverseString(String str){

		if(str.length() < 2) {
			return str;
		}

		return reverseString(str.substring(1,str.length())) + str.charAt(0) ;

	}
}