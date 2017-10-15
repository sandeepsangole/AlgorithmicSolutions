package Arrays;

public class ReverseString {
/*

	Given a sentence, reverse the order of the words.
	For example, if I give the sentence “The dog ran down the street”, the output should be “street the down ran dog The”
*/

/*
   The dog ran down the street
                        s
                        i

*/

	/*public class ReverseWords{

		public String reverseString(String str){

			if(str == null || str.length ==0)
				return str;

			StringBuilder sb = new StringBuilder();

			Stack<String> stack = new Stack<String>();
			int start = 0;

			for(int i =0 ; i<str.length;i++){
				char c = str.charAt(i);
				if(c == " "){
					String temp = str.subString(start,i-1);
					stack.push(temp);
					start = i + 1;


				}

			}

			stack.push(str[str.length-1]);


			while(!stack.isEmpty()){
				sb.append(stack.pop());
				if(!stack.isEmpty()){
					sb.append(" ");
				}

			}

			return sb.toString();

		}
	}*/

}
