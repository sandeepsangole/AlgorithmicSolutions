package dp;

public class MaxSumSubArray {

	public static void main(String[] args){
		MaxSumSubArray obj = new MaxSumSubArray();
		obj.getMaxSumSubArray(new int[]{-2, -5, 6, -2, -3, 1, 5, -6});

	}














	public int getMaxSumSubArray(int[] arr){
		int max = arr[0];
		int sum = 0;

		for(int i =0 ;i<arr.length;++i){
			System.out.println("sum :"+sum +" arr[i] "+arr[i] +" sum + arr[i] "+sum + arr[i] +" max : "+max);
			sum = Math.max(arr[i],sum + arr[i]);
			max= Math.max(max,sum);

		}

		System.out.println(max);
		return max;
	}

}
