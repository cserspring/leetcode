package dp;

public class HouseRobber {

    public int rob(int[] nums) {
        // dp[i] = max(dp[i-1], dp[i-2] + num[i])
    	
    	if (nums == null) return 0;
    	int len = nums.length;
    	if (len == 0) return 0;
    	if (len == 1) return nums[0];
    	
    	int[] dp = new int[len];
    	dp[0] = nums[0];
    	dp[1] = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < len; ++i)
    		dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
    	
    	return dp[len - 1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,5,4,6,7,1,6};
		HouseRobber h = new HouseRobber();
		System.out.println(h.rob(nums));
	}

}
