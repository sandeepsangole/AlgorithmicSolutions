package Arrays;

public class WaterLevel {

	public static void main(String[] args) {
		WaterLevel obj = new WaterLevel();

		System.out.println(obj.maxArea(new int[] { 2,1,5,6,2,3 }));
	}

	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int max   = 0;
		int left  = 0;
		int right = height.length - 1;
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[ left ],
					height[ right ]));
			if (height[ left ] < height[ right ])
				left++;
			else
				right--;
		}
		return max;
	}
}
