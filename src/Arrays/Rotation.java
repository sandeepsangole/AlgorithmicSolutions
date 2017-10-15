package Arrays;

public class Rotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer arr[] = {4,5,1,2,3};
		Integer arr1[] = {1,2,3,4,5};

		System.out.println("No. of rotate : " + findNumOfTimesRotated(arr));
		System.out.println("No. of rotate : " + findNumOfTimesRotated(arr1));
	}

	static int findNumOfTimesRotated(Integer arr[])
	{
		int i=0;
		for (i = 0 ; i < arr.length-1 ; i++)
		{

			if (arr[i] > arr[i+1])
				break;
		}
		if (i==arr.length-1)
			i=-1; // No rotation
		return i+1;

	}
}
