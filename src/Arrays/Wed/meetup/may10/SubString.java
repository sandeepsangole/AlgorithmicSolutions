package Arrays.Wed.meetup.may10;
/*
Assume you have a method indexOf which checks if one word is a substring of another.
 Given two strings, s1 and s2, write code to check if s2 is a rotation
  of s1 using only one call to indexOf( e.g., 'waterbottle' is a rotation of 'erbottlewat'")

 */
public class SubString {

	public static void main(String args[]){
		String s1 = "erbottlewat";
		String s2 = "waterbottle";

		System.out.println(indexOf(s1,s2));
	}

	public static boolean indexOf(String s1,String s2){
		String temp = s1 + s1;
		return (temp.indexOf(s2) != -1);

	}

}
