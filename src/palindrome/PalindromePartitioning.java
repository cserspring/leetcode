package palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> subRes = new ArrayList<String>();
        partition(res, subRes, s);
        return res;
    }
    
    private void partition(List<List<String>> res, List<String> subRes, String s) {
    	int n;
    	if (s == null || (n = s.length()) == 0) return;
    	if (isPalindrome(s)) {
    		List<String> subResCpy = new ArrayList<String>(subRes);
    		subResCpy.add(s);
    		res.add(subResCpy);
    	}

    	for (int i = 1; i < n; ++i) {
    		String firstPart = s.substring(0, i);
    		String secondPart = s.substring(i);    		
    		if (isPalindrome(firstPart)) {
    			List<String> subResCpy = new ArrayList<String>(subRes);
    			subResCpy.add(firstPart);
    			partition(res, subResCpy, secondPart);
    		}
    	}
    }
    
    private boolean isPalindrome(String s) {
    	int n = s.length();
    	for (int i = 0; i < n/2; ++i) {
    		if (s.charAt(i) != s.charAt(n - 1 - i)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aba";
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> res = p.partition(s);
		for (List<String> l : res) {
			for (String str : l) {
				System.out.print(str + "\t");
			}
			System.out.println();
		}
	}

}
