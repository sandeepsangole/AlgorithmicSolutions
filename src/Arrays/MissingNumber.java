package Arrays;

public class MissingNumber {
	public static void main(String args[]){
		MissingNumber mn = new MissingNumber();
		mn.findMissingNumber(new int[]{0,1,3});
	}
	public int findMissingNumber(int[] arr){
		int sum =0;
		for(int i =0;i < arr.length;i++){
				sum = sum + arr[i];
		}
		int n = arr.length;
		System.out.println(sum +" "+arr.length +" : "+n*(n+1)/2);

		return (n*(n+1)/2) - sum;
	}
}
