package dp;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (tlen > slen) return 0;
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int i = 0; i <= slen; ++i) {
        	for (int j = 0; j <= tlen; ++j) {
        		if (j == 0) {
        			dp[i][j] = 1;
        			continue;
        		}
        		
        		if (j > i) {
        			dp[i][j] = 0;
        			continue;
        		}
        		
        		if (s.charAt(i - 1) == t.charAt(j - 1))
        			dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        		else
        			dp[i][j] = dp[i - 1][j];        		
        	}
        }
        return dp[slen][tlen];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequences d = new DistinctSubsequences();
		System.out.println(d.numDistinct("rabbbit", "rabbit"));
	}

}
