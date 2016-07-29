package dfs;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if (wordDict.contains(s))
    		return true;
    	//boolean flag = false;
   		int n = s.length();
   		for (int i = 1; i <= n; ++i) {
   			String candidate = s.substring(0, i);
   			if (wordDict.contains(candidate) && wordBreak(s.substring(i), wordDict))
   				return true;   			
   		}
   		
   		return false;
    }
    /*
    private boolean dfs(String s, Set<String> wordDict) {
    	if (wordDict.contains(s))
    		return true;
    	//boolean flag = false;
   		int n = s.length();
   		for (int i = 1; i <= n; ++i) {
   			String candidate = s.substring(0, i);
   			if (wordDict.contains(candidate) && dfs(s.substring(i), wordDict))
   				return true;   			
   		}
   		
   		return false;
    }*/
    
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
