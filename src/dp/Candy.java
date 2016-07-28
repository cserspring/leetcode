package dp;

public class Candy {
    public int candy(int[] ratings) {
        int n;
        if (ratings == null || (n = ratings.length) == 0) return 0;
        int sum = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
        	dp[i] = ratings[i] > ratings[i-1] ? (1 + dp[i-1]) : 1;
        }
        
        sum += dp[n-1];
        for (int i = n-1; i >= 1; --i) {
        	if (ratings[i-1] > ratings[i] && dp[i-1] <= dp[i])
        		dp[i-1] = 1 + dp[i];
        	sum += dp[i-1];
        }
        
        return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
