package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] map = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return res;
        res.add("");
        return DFS(map, res, digits, 0);
    }
    
    private List<String> DFS(String[] map, List<String> subRes, String digits, int pos) {
    	if (pos == digits.length()) return subRes;
    	int index = digits.charAt(pos) - '0';
    	List<String> res = new ArrayList<String>();
    	for (String s : subRes) {
    		for (int j = 0; j < map[index].length(); ++j) {
    			res.add(s + map[index].charAt(j));
    		}
    	}
    	
    	return DFS(map, res, digits, ++pos);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
		System.out.println(l.letterCombinations("23"));
	}

}
