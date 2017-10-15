package personal.test;

public class ReverseStringRecursion {
	public static void main(String args[])
	{
		ReverseStringRecursion strRec = new ReverseStringRecursion();
		System.out.println(strRec.isPalimdrome("Sandeep"));
		System.out.println(strRec.reverseRecursively("Sandeep"));
	}

	public static String reverseRecursively(String str) {


		//base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}

	public String isPalimdrome(String word)
	{
		if(word.length() < 2)
		{

			return word;
		}

			return isPalimdrome(word.substring(1)) + word.charAt(0);

	}
}
