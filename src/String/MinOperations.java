package String;

public class MinOperations {

	public static void main(String args[]){
		String source = "a";
		String target = "bx";
		MinOperations obj = new MinOperations();
		System.out.println(obj.minOperations(source,source.length() - 1, target,target.length() - 1));


	}

	public int minOperations(String source,int sPointer,String target,int tPointer){

		if(sPointer < 0){
			return 0;
		}

		if(tPointer < 0){
			return 0;
		}

		if(source.charAt(sPointer) == target.charAt(tPointer)){
			return minOperations(source,sPointer-1,target,tPointer -1);
		}

		return 1 + min(
				minOperations(source,sPointer,target,tPointer - 1),//insert
				minOperations(source,sPointer - 1,target,tPointer - 1),//replace
				minOperations(source,sPointer - 1,target,tPointer)//delete
		);
	}

	public int min(int a , int b,int c){
		int temp = Math.min(a,b);
		return Math.min(temp,c);
	}


}
