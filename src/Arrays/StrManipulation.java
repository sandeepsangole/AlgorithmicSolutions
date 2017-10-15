package Arrays;

 class StrManipulation{

	public static void combinations(String suffix,String prefix){

		if(prefix.length()==0){
			System.out.println(suffix);
			return;
		}

		for(int i=0;i<prefix.length();i++) {

				combinations(suffix + prefix.charAt(i), prefix.substring(i + 1, prefix.length()));
		}
	}

	public static void main (String args[]){
		combinations("","9685");
	}
}