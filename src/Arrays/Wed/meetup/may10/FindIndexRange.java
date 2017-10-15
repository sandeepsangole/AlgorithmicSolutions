package Arrays.Wed.meetup.may10;
/*
Return a range in an array that has the starting and ending indexes of a target value in a sorted array.
Ex: findRange( [1,2,2,2,2,2,2,2,5,6,7], 2 ); // [1, 7]
 */
public class FindIndexRange {

	public static void main(String args[]){
		int[] range = {1,2,2,2,2,2,2,2,5,6,7};
		int index = 2;

		int[] result = new int[2];

		FindIndexRange obj = new FindIndexRange();
		obj.binarySearch(range,index,0,range.length - 1, result);

		System.out.println(result[0]);
		System.out.println(result[1]);

	}

	void binarySearch(int[] range,int target,int start,int end,int[] result){

				//recursion base case
				if(start > end)
					return;

				//if left and right are matching target index
				if(range[start] == range[end] && range[start] == target){
					result[0] = range[start];
					result[1] = range[end];
					return;
				}

				int mid = (start + end) / 2;

				if(range[mid] > target){
					binarySearch(range,target,start,mid-1,result);
				}
				else if(range[mid] < target){
					binarySearch(range,target,mid+1,end,result);
				}
				else
				{
					result[0] = mid;
					result[1] = mid;
					int p1 = mid;
					while(p1 >= start && range[p1] == range[p1 -1]){
						p1--;
						result[0] = p1;


					}

					int p2 = mid;
					while(p2 <= end && range[p2] == range[p2 +1])
					{
						p2++;
						result[1] = p2;

					}

					return;
				}
	}
}
