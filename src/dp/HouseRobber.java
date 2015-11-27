package dp;

public class HouseRobber {

    public int rob(int[] nums) {
        // The original dp solution is dp[i] = max(dp[i-1], dp[i-2] + num[i])
    	// We can save the space by not using array to store dp
    	if (nums == null) return 0;
    	int len = nums.length;
    	if (len == 0) return 0;
    	
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	for (int i = 0; i < len; ++i) {
    		c = Math.max(b, a + nums[i]);
    		a = b;
    		b = c;
    	}
    	
    	return c;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1};
		HouseRobber h = new HouseRobber();
		System.out.println(h.rob(nums));
	}

}
