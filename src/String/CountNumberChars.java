package String;

public class CountNumberChars {

	public static void main(String[] args){
		String s = "a5$&45NdG";

		//49--57
		//65-122
		int charcount = 0;
		int nocount = 0;
		for(int i =0;i<s.length();i++){
			int no = (int)s.charAt(i);
			if(no >= 65 && no <=122 )
				charcount++;

			if(no >= 49 && no <=57 )
				nocount++;


		}System.out.println(nocount);
		System.out.println(charcount);
	}
}
