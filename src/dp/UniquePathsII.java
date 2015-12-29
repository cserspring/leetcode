package dp;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m;
        int n;
        if (obstacleGrid == null || (m = obstacleGrid.length) == 0 || (n = obstacleGrid[0].length) == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; ++i) dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i - 1][0] : 0;
        for (int i = 1; i < n; ++i) dp[0][i] = obstacleGrid[0][i] == 0 ? dp[0][i - 1] : 0;
        for (int i = 1; i < m; ++i) {
        	for (int j = 1; j < n; ++j) {
        		dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
        	}
        }
        
        return dp[m - 1][n - 1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {0,0,0},
		                 {0,1,0},
		                 {0,0,0}
		               };
		UniquePathsII u = new UniquePathsII();
		System.out.println(u.uniquePathsWithObstacles(grid));
	}

}
