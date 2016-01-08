package dp;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1 + len2) return false;
        char[] c12 = (s1 + s2).toCharArray();
        Arrays.sort(c12);
        char[] c3 = s3.toCharArray();
        Arrays.sort(c3);
        if (!isEqual(c12, c3, len3)) return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; ++i) {
        	dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0];
        }
        
        for (int i = 1; i <= len2; ++i) {
        	dp[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && dp[0][i - 1];
        }
        
        for (int i = 1; i <= len1; ++i) {
        	for (int j = 1; j <= len2; ++j) {
        		dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) || 
        				(s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
        	}
        }
        
        return dp[len1][len2];
    }
    
    private boolean isEqual(char[] c0, char[] c1, int n) {
    	for (int i = 0; i < n; ++i) {
    		if (c0[i] != c1[i])
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString i = new InterleavingString();
		System.out.println(i.isInterleave("a", "b", "ab"));
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
