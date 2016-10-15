package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	private final int LEN = 10;
	
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<String>();
    	int n;
    	if (s == null || (n = s.length()) < 10) return res;
    	HashMap<Character, Integer> basic = new HashMap<Character, Integer>();
    	basic.put('A', 0);
    	basic.put('C', 1);
    	basic.put('G', 2);
    	basic.put('T', 3);
    	
        Set<Integer> map = new HashSet<Integer>();
        Set<Integer> existed = new HashSet<Integer>();
        int src = 0;
        for (int i = 0; i < LEN; ++i) {
        	src = (src << 2) + basic.get(s.charAt(i));
        }
        
        map.add(src);
        for (int i = 10; i < n; ++i) {
        	src = ((src & 0x3FFFF) << 2) + basic.get(s.charAt(i));
        	if (map.contains(src) && !existed.contains(src)) {
        		res.add(s.substring(i - 9, i + 1));
        		existed.add(src);
        	} else {
        		map.add(src);
        	}
        }
        
        return res;
    }    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		RepeatedDNASequences r = new RepeatedDNASequences();
		List<String> res = r.findRepeatedDnaSequences(s);
		for (String i : res) {
			System.out.println(i);
		}
	}

}
