package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
    	if (s == null || t == null) return false;
        int len = s.length();
        if (len == 0) return true;
        Map<Character, Character> stmap = new HashMap<Character, Character>();
        Map<Character, Character> tsmap = new HashMap<Character, Character>();
        for (int i = 0; i < len; ++i) {
        	char c1 = s.charAt(i);
        	char c2 = t.charAt(i);
        	if (stmap.containsKey(c1)) {
        		if (c2 != stmap.get(c1))
        			return false;
        	} else if (tsmap.containsKey(c2)) {
        		if (c1 != tsmap.get(c2))
        			return false;
        	} else {
        		stmap.put(c1, c2);
        		tsmap.put(c2, c1);
        	}
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicStrings i = new IsomorphicStrings();
		System.out.println(i.isIsomorphic("aa", "ab"));
		System.out.println(i.isIsomorphic("aa", "ba"));
		System.out.println(i.isIsomorphic("title", "paper"));
	}

}
