package String;

public class StringCompression {

	public static void main(String[] args){
		StringCompression obj = new StringCompression();
		System.out.println(obj.compressString("aabcccccaaaasssd"));
	}

	public String compressString(String str){
		StringBuilder compressed = new StringBuilder();
		int count = 0;
		int i =0;
		for(i =0;i<str.length()-1;i++){
			count++;
			//If next character is different than the current ,append this char to result
			if(str.charAt(i) != str.charAt(i+1)){
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}

		count++;
		compressed.append(str.charAt(i));
		compressed.append(count);



		return compressed.length() < str.length() ? compressed.toString() : str;
	}
}
