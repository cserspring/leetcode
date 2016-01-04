package recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        dfs(res, "", s, 1);
        return res;
    }
    
    private void dfs(List<String> res, String t, String s, int k) {
    	if (k == 4) {
    		if (isValid(s))
    			res.add(t + s);
    	} else {
    		int n = s.length();
    		for (int i = 1; i <= 4; ++i) {
    			if (n >= i && isValid(s.substring(0, i))) {
    				dfs(res, t + s.substring(0, i) + ".", s.substring(i, n), k + 1);
    			}
    		}
    	}
    }
    
    private boolean isValid(String s) {
    	if (s.length() > 0 && s.length() <= 3) {
    		if (s.length() > 1 && s.charAt(0) == '0') return false;
    		int value = Integer.parseInt(s);
    		if (value <= 255) return true;
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses r = new RestoreIPAddresses();
		for (String s : r.restoreIpAddresses("010010")) {
			System.out.println(s);
		}
	}

}
