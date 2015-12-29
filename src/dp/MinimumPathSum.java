package dp;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m;
        int n;
        if (grid == null || (m = grid.length) == 0 || (n = grid[0].length) == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int i = 1; i < n; ++i) dp[0][i] = dp[0][i - 1] + grid[0][i];
        for (int i = 1; i < m; ++i) {
        	for (int j = 1; j < n; ++j) {
        		dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        	}
        }
        
        return dp[m - 1][n - 1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {4,3,1},
                {2,1,3},
                {8,1,3}
              };
		MinimumPathSum m = new MinimumPathSum();
		System.out.println(m.minPathSum(grid));
	}

}
