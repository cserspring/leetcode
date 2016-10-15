package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
	private final int LEN = 10;
	
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<String>();
    	int n;
    	if (s == null || (n = s.length()) == 0) return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n - LEN + 1; ++i) {
        	String subSeq = s.substring(i, i + 10);
        	if (map.containsKey(subSeq)) {
        		map.put(subSeq, map.get(subSeq) + 1);
        	} else {
        		map.put(subSeq, 1);
        	}
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	if (entry.getValue() > 1) {
        		res.add(entry.getKey());
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
