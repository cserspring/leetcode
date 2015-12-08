package string;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        String max = "";
        for (int i = 0; i < len; ++i) {
        	String res = getStr(s, len, i, i);
        	if (res.length() > max.length())
        		max = res;
        	if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
        		res = getStr(s, len, i, i + 1);
        		if (res.length() > max.length())
        			max = res;
        	}
        }
        
        return max;
    }
    
    private String getStr(String s, int len, int left, int right) {
    	while (right < len && left >= 0 && s.charAt(left) == s.charAt(right)) {
    		--left;
    		++right;
    	}
    	return s.substring(left + 1, right);
    }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome("aabbcc"));
	}

}
