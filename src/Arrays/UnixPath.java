package Arrays;

import java.util.Stack;
/*

	Simplify unix path
 */
public class UnixPath {

	public static void main(String args[]){
		String path ="/home//foo/";
		UnixPath obj = new UnixPath();
		System.out.print(obj.simplifyPath(path));
	}

	public String simplifyPath(String str){
		StringBuilder result = new StringBuilder();
		String str1 = "";
		String[] arr = str.split("/");
		Stack<String> stack = new Stack<String>();
		for(String a : arr){

			if(a.equals(".") || a.equals(" ") || a.length() == 0 ){
				continue;
			}
			if(a.equals(".."))
			{
				if(!stack.isEmpty()){
					stack.pop();
				}
			}

			else {
				stack.push(a);
			}

		}

		while(!stack.isEmpty()){
			str1 = stack.pop()+"/" + str1;
		}
		return str1.toString();
	}


}
