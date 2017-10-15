package dp;

public class HouseRobber {

	public static void main(String args[]) {
		HouseRobber obj = new HouseRobber();
		System.out.println(obj.rob(new int[] { 1, 50, 1, 50 ,1,1}));
	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[ 0 ];
		int[] dp = new int[ nums.length ];
		dp[ 0 ] = nums[ 0 ];
		dp[ 1 ] = Math.max(nums[ 0 ], nums[ 1 ]);
		for (int i = 2; i < nums.length; i++) {
			dp[ i ] = Math.max(dp[ i - 2 ] + nums[ i ], dp[ i - 1 ]);
		}
		return dp[ nums.length - 1 ];
	}

}
