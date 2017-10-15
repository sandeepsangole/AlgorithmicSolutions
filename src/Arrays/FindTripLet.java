package Arrays;

public class FindTripLet {

	public static void main(String args[]){
		FindTripLet obj = new FindTripLet();
		obj.increasingTriplet(new int[]{10,6,5,7,4,3});
	}

	public boolean increasingTriplet(int[] nums) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int z = nums[i];
			if (x >= z) {
				x = z;// update x to be a smaller value
			} else if (y >= z) {
				y = z; // update y to be a smaller value
			} else {
				return true;
			} }
		return false;
	}

}
