package Arrays;

public class NumberPalindrome{

	public static void main(String args[]){
		System.out.println(isNumberPalindrome(121));
	}

	public static boolean isNumberPalindrome(long no){

		long original = no;
		long output = 0;
		boolean isPalindrome = false;

		while( no > 0){
			output = (output * 10) + (no % 10);
			no = no / 10;
		}
		System.out.println(output +" : "+no);
		return 	output == original;

	}

}
