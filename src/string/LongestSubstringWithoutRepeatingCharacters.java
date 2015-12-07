package string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int lastIndex = -1;
        for (int i = 0; i < len; ++i) {
        	char c = s.charAt(i);
        	if (map.containsKey(c) && lastIndex < map.get(c)) {
        		lastIndex = map.get(c);
        	}
        	
        	if (i - lastIndex > max)
        		max = i - lastIndex;
        	map.put(c, i);
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
