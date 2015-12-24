package dp;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
    	int slen = s.length();
    	int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int i = 1; i <= plen; ++i)
        	dp[0][i] = p.charAt(i - 1) == '*' ? dp[0][i - 1] : false;
        for (int i = 1; i <= slen; ++i)
        	dp[i][0] = false;
        for (int i = 1; i <= slen; ++i) {
        	for (int j = 1; j <= plen; ++j) {
        		if (p.charAt(j - 1) == '*') {
        			dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
        		} else {
        			dp[i][j] = match(s.charAt(i - 1), p.charAt(j - 1)) && dp[i - 1][j - 1];
        		}
        	}
        }
        
        return dp[slen][plen];
    }
    
    private boolean match(char a, char b) {
    	if (b == '?' || b == '*')
    		return true;
    	return a == b;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching w = new WildcardMatching();
		System.out.println(w.isMatch("aa","a"));
		System.out.println(w.isMatch("aa","aa"));
		System.out.println(w.isMatch("aaa","aa"));
		System.out.println(w.isMatch("aa", "*"));
		System.out.println(w.isMatch("aa", "a*"));
		System.out.println(w.isMatch("ab", "?*"));
		System.out.println(w.isMatch("aab", "c*a*b"));
		
	}

}
