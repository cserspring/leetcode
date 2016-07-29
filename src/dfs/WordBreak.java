package dfs;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	int n;
    	if (s == null || (n = s.length()) == 0) return false;
    	boolean[] dp = new boolean[n+1];
    	dp[0] = true;
    	for (int i = 1; i <= n; ++i) {
    		for (int j = 0; j < i; ++j) {
    			if (dp[j] && wordDict.contains(s.substring(j, i))) {
    				dp[i] = true;
    				break;
    			}
    		}
    	}
    	
    	return dp[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("dog");
		WordBreak w = new WordBreak();
		System.out.println(w.wordBreak(s, wordDict));		
	}

}
