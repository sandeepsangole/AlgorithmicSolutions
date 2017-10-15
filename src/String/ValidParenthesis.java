package String;


import java.util.*;

public class ValidParenthesis{

	public static void main(String[] args){
		List<String> res = new ArrayList<String>();
		generateParenthesis(3,3,"",res);
		System.out.println(res);
	}



	public static List<String> generateParenthesis(int left,int right,String str,List<String> res){

		if (left > right)
			return res;

		if(left == 0 && right == 0)
		{
			res.add(str);
			return res;
		}

		if(left > 0){
			 generateParenthesis(left - 1,right,str+"(",res);

		}

		if(right > 0){
			 generateParenthesis(left,right-1,str+")",res);
		}

	return res;

	}
}