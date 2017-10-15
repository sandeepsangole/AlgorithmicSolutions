package String;

import java.util.*;

public class   Parenthesis {
	public static void main(String args[]) {
		Parenthesis       obj    = new Parenthesis();
		ArrayList<String> result = new ArrayList<String>();
		obj.dfs(result, "", 3, 3);
		System.out.println(result);

		/*ArrayList<String> result1 = new ArrayList<String>();
		obj.helper(0,0,3,"",result1);
		System.out.println(result1);*/
	}

  public void helper(int left , int right,int n,String sol,List<String> res){
		if(left + right == 2 * n) {
			res.add(sol);
			return;
		}

		if(left < n){
			this.helper(left+1,right,n,sol+"(",res);
		}
		if(right < left){
			this.helper(left,right+1,n,sol+")",res);
		}

  }

	public void dfs(ArrayList<String> result, String s, int left, int right) {
	//	System.out.println("Left : " + left + " Right : " + right);
		//System.out.println(s);
		if (left > right)
			return;
		if (left == 0 && right == 0) {
			//System.out.println(s);
			result.add(s);
			return;
		}
		if (left > 0) {
			dfs(result, s + "(", left - 1, right);
		}
		if (right > 0) {
			dfs(result, s + ")", left, right - 1);
		}
	}

}
