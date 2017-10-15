package String;

public class LUS {

	public static void main(String args[]){
		LUS obj = new LUS();
		System.out.println(obj.findLUSlength("aefawfawfawfaw",
				"aefawfeawfwafwaef"));
	}

	public int lcsDynamic(char str1[],char str2[]){

		int temp[][] = new int[str1.length + 1][str2.length + 1];
		int max = 0;
		for(int i=1; i < temp.length; i++){
			for(int j=1; j < temp[i].length; j++){
				if(str1[i-1] == str2[j-1]) {
					temp[i][j] = temp[i - 1][j - 1] + 1;
				}
				else
				{
					temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
				}
				if(temp[i][j] > max){
					max = temp[i][j];
				}
			}
		}
		System.out.println(max);
		return max;

	}

	public int findLUSlength(String a, String b) {
		int count = 0;
		if(a ==null || a.length() == 0) return count;
		if(b ==null || b.length() == 0) return count;

		char[] ac = a.toCharArray();
		char[] bc =  b.toCharArray();

		int commonSubSeq = lcsDynamic(ac,bc);

		if(a.length() > b.length()){
		    return a.length();
		}
		else
		{
			return b.length();
		}


	}
}
