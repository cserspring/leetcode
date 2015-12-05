package dp;

public class JumpGameII {

    public int jump(int[] nums) {    	
    	int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; ++i)
        	dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        // In order to save time, we don't visit the elements which already been visited.
        int start = 1;
        for (int i = 0; i < len - 1; ++i) {
        	start = go(i, nums[i], start, dp);
        }
        
        return dp[len-1];
    }
    
    // Get next start position.
    private int go(int current, int step, int start, int[] dp) {
    	int i = start;
    	for (; i <= current + step && i < dp.length; ++i) {
    		if (dp[i] > dp[current] + 1)
    			dp[i] = dp[current] + 1;
    	}
    	
    	return i;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,3,1,1,4 };
		JumpGameII j = new JumpGameII();
		System.out.println(j.jump(nums));
	}

}
