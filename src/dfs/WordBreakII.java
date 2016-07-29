package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	List<String> res = new ArrayList<String>();
    	int n;
    	if (s == null || (n = s.length()) == 0) return res;
    	
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
    	
        if (dp[n])
        	dfs(res, s, wordDict, "");
        return res;
    }
    
    private void dfs(List<String> res, String s, Set<String> wordDict, String foundWords) {
    	if (s.length() == 0) {
    		res.add(foundWords.substring(0, foundWords.length() - 1));
    		return;
    	}

   		int n = s.length();
   		for (int i = 1; i <= n; ++i) {
   			String candidate = s.substring(0, i);
   			if (wordDict.contains(candidate)) {
   				dfs(res, s.substring(i), wordDict, foundWords + candidate + " ");
   			}
   		}
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
		WordBreakII w = new WordBreakII();
		List<String> res = w.wordBreak(s, wordDict);
		for (String str : res) {
			System.out.println(str);
		}
	}

}
