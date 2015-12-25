package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; ++i) {
        	char[] chars = strs[i].toCharArray();
        	Arrays.sort(chars);
        	String key = String.valueOf(chars);
        	if (map.containsKey(key)) {
        		map.get(key).add(strs[i]);
        	} else {
        		List<String> list = new ArrayList<String>();
        		list.add(strs[i]);
        		map.put(key, list);
        	}
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> l : map.values()) {
        	Collections.sort(l);
        	res.add(l);
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagrams g = new GroupAnagrams();
		List<List<String>> res = g.groupAnagrams(strs);
		for (List<String> subRes : res) {
			for (String s : subRes)
				System.out.print(s + "\t");
			System.out.println("\n");
		}
	}

}
