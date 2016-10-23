package design;

import java.util.HashSet;
import java.util.Set;

public class AddAndSearchWord {

	private Set<String> set = new HashSet<String>();
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        set.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        for (String s : set) {
        	if (equal(s, word))
        		return true;
        }
        
        return false;
    }
    
    private boolean equal(String s, String t) {
    	int slen = s.length();
    	int tlen = t.length();
    	if (slen != tlen) return false;
    	for (int i = 0; i < slen; ++i) {
    		if (t.charAt(i) != '.' && t.charAt(i) != s.charAt(i))
    			return false;
    	}
    	
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
