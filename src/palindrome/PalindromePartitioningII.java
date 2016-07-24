package palindrome;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) return 0;
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
        	for (int j = 0; j <= i; ++j) {
        		if (i == j) {
        			isPalindrome[j][i] = true;
        		} else {
        			isPalindrome[j][i] = s.charAt(j) == s.charAt(i) && ((i - j) <= 2 || isPalindrome[j+1][i-1]);
        		}
        	}
        }
        
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
        	dp[i] = i;
        	if (isPalindrome[0][i]) {
        		dp[i] = 0;
        	} else {
        		for (int j = 0; j < i; ++j) {
        			if (isPalindrome[j+1][i] && dp[i] > 1 + dp[j]) {
        				dp[i] = 1 + dp[j];
        			}
        		}
        	}
        }
        
        return dp[n-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII p = new PalindromePartitioningII();
		System.out.println(p.minCut("abccddcc"));
	}

}
