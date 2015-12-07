package string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0; i < len; ++i) {
        	map.put(s.charAt(i), i);
        	for (int j = i + 1; j < len; ++j) {
	        	if (!map.containsKey(s.charAt(j))) {
	        		map.put(s.charAt(j), j);
	        	} else {
	        		i = map.get(s.charAt(j));
	        		break;
	        	}
        	}
        	
        	int count = map.size();
    		if (count > max) {
    			max = count;
    		}
    		map.clear();
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb";
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring(s));
	}

}
