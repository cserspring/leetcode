package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
    	int len;
    	int numWords;
    	int wordLen;
        if (s == null || (numWords = words.length) == 0 || (len = s.length()) == 0) return res;
        if (words == null || (wordLen = words[0].length()) == 0) return res;
        int totalWordsLen = wordLen*numWords;
        if (totalWordsLen > len) return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
        	if (map.containsKey(w)) {
        		map.put(w, map.get(w) + 1);
        	} else {
        		map.put(w, 1);
        	}
        }
        
        for (int i = 0; i <= len - totalWordsLen; ++i) {
        	if (isSubString(s.substring(i, i + totalWordsLen), new HashMap<String, Integer>(map), wordLen)) {
        		res.add(i);
        	}
        }
        
        return res;
    }
    
    private boolean isSubString(String subStr, HashMap<String, Integer> map, int wordLen) {
    	for (int i = 0; i <= subStr.length() - wordLen; i += wordLen) {
    		String word = subStr.substring(i, i + wordLen);
    		
    		if (map.containsKey(word) && map.get(word) > 0) {
    			map.put(word, map.get(word) - 1);
    		} else {
    			return false; // If !contains or value is 0, return immediately.
    		}
    	}
    	
    	for (String word : map.keySet()) {
    		if (map.get(word) != 0)
    			return false;
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		String str = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		for(int i : s.findSubstring(str, words)) {
			System.out.println(i);
		}
	}

}
