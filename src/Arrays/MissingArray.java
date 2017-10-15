package Arrays;

public class MissingArray {
	public static void main(String[] args){
		int X =0, Y =0;
		int[] arr = {1,2,4,6,3,7,8};
		for(int i = 0;i<arr.length;i++){
			X = X ^ arr[i];

		}
	//	System.out.println(X);
		for(int i = 1;i<=arr.length;i++){
			Y = Y ^ arr[i];
			//System.out.println(Y);
		}
		System.out.println(X^Y);

	}
}
