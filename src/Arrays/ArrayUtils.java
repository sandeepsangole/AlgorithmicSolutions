package Arrays;
import java.util.*;

public class ArrayUtils {

	public void moveZeros(int[] arr) {

		int i = 0;
		int j = 0;
		while (j < arr.length) {
			if (arr[ j ] == 0) {
				j++;
			} else {
				arr[ i ] = arr[ j ];
				i++;
				j++;
			}
		}

		while (i < arr.length) {
			arr[ i ] = 0;
			i++;

		}

	}

	public int removeElement(int[] A,int ele){
		int i= 0;
		int j =0;

		while(i < A.length && j< A.length){
			if(A[j] != ele){
				A[i] = A[j];
				i++;
			}

			j++;
		}

		return i;
	}

	public static int[] removeDuplicates(int[] A) {
		if (A.length < 2)
			return A;
		int j = 0;
		int i = 1;
		while (i < A.length) {

			System.out.println(A[i]+" : ");
			System.out.println(" i : "+i +" j :"+j +" A "+A.length);
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++; }
		}
		int[] B = Arrays.copyOf(A, j + 1);
		return B;
	}


	public int minSubArrayLen(int s, int [] nums) {
		if (nums == null && nums.length == 1)
			return 0;

		int result = nums.length;

		int     start  = 0;
		int     sum    = 0;
		int     i      = 0;
		boolean exists = false;

		while (i <= nums.length) {
			System.out.println("Start : "+start +" Sum : "+sum +" i : "+i +"result : "+result +" s : "+s);
			if (sum >= s) {
				exists = true;
				if (start == i - 1) {
					return 1;
				}
				result = Math.min(result, i - start);
				sum = sum - nums[ start ];
				start++;
			} else {
				if (i == nums.length)
					break;

				sum = sum + nums[ i ];
				i++;
			}
		}

		if (exists)
			return result;
		else
			return 0;
	}


	public static void main(String args[]){
		ArrayUtils arr = new ArrayUtils();
	//	System.out.println(arr.minSubArrayLen(7, new int[]{5,3,2,3,8}));
		//System.out.println(arr.removeDuplicates(new int[]{1,1,2}));
		//System.out.println(arr.removeElement(new int[]{1,2,5,8,5,4},5));
		//arr.moveZeros(new int[]{1,0,5,8,0,9});
		System.out.println(arr.summaryRangesSolution(new int[]{0,1,2,4,5,7}));
		//arr.merge(new int[]{1,5,7},3,new int[]{2,6,8},3);

		System.out.println();
	}

	public List<String> summaryRangesSolution(int[] nums){

		int prev = nums[0];
		int first = prev;
		List<String> result = new ArrayList<String>();
		for(int i=1;i<nums.length;i++){
			if(nums[i] == prev+1){
				if(i == nums.length -1)
				{
					result.add(first+"->"+nums[--i]);
				}
				prev++;
			}
			else
			{
				result.add(first+"->"+nums[i-1]);
				first=nums[i];
				prev = first;

				if(i == nums.length - 1)
				{
					result.add(""+nums[i]+"");
				}
			}
		}
		return result;
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return result;
		if (nums.length == 1) {
			result.add(nums[ 0 ] + "");
		}
		int pre   = nums[ 0 ]; // previous element
		int first = pre; // first element of each range

		for (int i = 1; i < nums.length; i++) {
			//check if in sequence - diff = 1
			if (nums[ i ] == pre + 1) {
				//check if last item
				if (i == nums.length - 1) {
					result.add(first + "->" + nums[ i ]);
				}
			} else {
				//if only one item
				if (first == pre) {
					result.add(first + "");
				} else {
					result.add(first + "->" + pre);
				}
				if (i == nums.length - 1) {
					result.add(nums[ i ] + "");
				}
				first = nums[ i ];
			}
			//make current as previous
			pre = nums[ i ];
		}
		return result;
	}

	public int removeElementTest(int A[],int ele){
		int i = 0;;
		int j= 0;
		while(j < A.length){
			if(A[j] != ele){
				A[i] = A[j];
				i++;
			}
			j++;

		}
		return i;
	}

	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (k >= 0) {
			if (j < 0 || (i >= 0 && A[i] > B[j]))
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
	}


}
