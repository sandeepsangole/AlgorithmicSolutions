package Arrays;

public class XOR {

	public static void main(String args[]){
		int[] arr ={0,0};
		int res = 0;
		for(int i:arr){
			res = res ^ arr[i];
		}
		System.out.println(res);
	}
}
