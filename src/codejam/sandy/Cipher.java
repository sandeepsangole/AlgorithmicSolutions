package codejam.sandy;


public class Cipher {

	public static void main(String args[]){
		Cipher c = new Cipher();
		System.out.println(c.decrypt("OMDU"));
	}
	/*
		ADMZZO
	*/

	public String decrypt(String enStr){

		if(enStr == null || enStr.length() == 0 ){
			return null;
		}

		char[] res = new char[enStr.length()];
		int adj = 0;
		for(int i=0;i<enStr.length();i+=2){
			adj = (enStr.charAt(i) + 'A' - adj) % 26 ;
			res[i+1] = (char)(adj + 'A');
		}

		adj =0;
		for(int j = enStr.length() - 1 ;j>0;j-=2){
			adj =  (enStr.charAt(j) + 'A' - adj) % 26;
			res[j-1] = (char)(adj + 'A');
		}


		return String.copyValueOf(res);


	}
}