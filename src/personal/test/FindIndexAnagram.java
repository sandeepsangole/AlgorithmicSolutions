package personal.test;

import java.util.Arrays;

public class FindIndexAnagram {
	public static void main(String args[])
	{
		String mainString = "abcbsaasabnnba";
		String anagramString = "ab";

		FindIndexAnagram a  = new FindIndexAnagram();
		a.findIndexOfString(mainString,anagramString);
	}

	public void findIndexOfString(String mainString,String anagram)
	{
		char[] anagramArray = anagram.toCharArray();
		Arrays.sort(anagramArray);

		int subStringLength = anagramArray.length;

		for(int i=0;i< mainString.length();i++)
		{
				if(i + subStringLength <=mainString.length()) {

					char ch[] = mainString.substring(i, (i + subStringLength)).toCharArray();
					Arrays.sort(ch);
					if(Arrays.equals(ch,anagramArray))
						System.out.println(i);
				}


		}
	}


	/*public void findIndexOFStringNew(String mainString,String anagram){

		for(int i =0;i<mainString.length();i=i+anagram.length() -1){

			for(){

				}
		}

	}*/
}
