package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        Map<Character, Integer> base = new HashMap<Character, Integer>();
        for (int i = 0; i < n; ++i) {
        	char c = t.charAt(i);
        	if (base.containsKey(c)) {
        		base.put(c, base.get(c) + 1);
        	} else {
        		base.put(c, 1);
        		found.put(c, 0);
        	}
        }
        
        int count = 0;
        int ss = -1;
        int ee = m;
        for (int end = 0, start = 0; end < m; ++end) {
        	char c = s.charAt(end);
        	if (base.containsKey(c)) {
        		found.put(c, found.get(c) + 1);
        		if (found.get(c) <= base.get(c))
        			++count;
        		if (count == n) {
        			char startChar = s.charAt(start);
        			while (!base.containsKey(startChar) || found.get(startChar) > base.get(startChar)) {
        				if (base.containsKey(startChar))
        					found.put(startChar, found.get(startChar) - 1);
        				startChar = s.charAt(++start);
        			}
        			
        			if (end - start < ee - ss) {
        				ee = end;
        				ss = start;
        			}
        		}
        	}
        }
        
        return ss == -1 ? "" : s.substring(ss, ee + 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "ADOBECODEBANC";
		String T = "ABC";
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow(S, T));
	}

}
