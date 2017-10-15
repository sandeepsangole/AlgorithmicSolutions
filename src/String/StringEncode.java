package String;

public class StringEncode {

	public static void main(String args[]){
		String str = "aabcccccaaaaa";
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int i =0;
		for(i =0;i<str.length() - 1;i++){

			count++;
			if(str.charAt(i) == str.charAt(i+1)){
				continue;
			}
			else
			{
				sb.append(str.charAt(i)).append(count);
				count = 0;
			}

		}

		sb.append(str.charAt(i)).append(++count);
		System.out.print(sb.toString());

	}

}
