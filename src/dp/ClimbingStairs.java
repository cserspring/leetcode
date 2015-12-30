package dp;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(4));
	}

}
