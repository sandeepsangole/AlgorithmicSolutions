package Arrays;

public class ContiguosSeqSum {

	public static void main(String args[]){
		ContiguosSeqSum obj = new ContiguosSeqSum();
		System.out.println(obj.getMaxSum(new int[]{5,-9,6,-2,3}));

	}
	int getMaxSum(int[] a){
		int maxSum = 0;
		int sum = 0;
		for(int i =0;i<a.length;i++){
			sum+=a[i];
			if(maxSum<sum){
				maxSum = sum;
			}
			else if(sum < 0)
			{
				sum = 0;
			}
		}

		return maxSum;
	}
}
