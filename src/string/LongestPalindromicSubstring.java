package string;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        String max = "";
        for (int i = 0; i < len; ++i) {
        	String res = getOddStr(s, i, len);
        	if (res.length() > max.length())
        		max = res;
        	res = getEvenStr(s, i, len);
        	if (res.length() > max.length())
        		max = res;
        }
        
        return max;
    }
    
    private String getOddStr(String s, int i, int len) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(s.charAt(i));
    	int step = 1;
    	while (i + step < len && i - step >= 0 && s.charAt(i + step) == s.charAt(i - step)) {
    		sb.append(s.charAt(i + step));
    		sb.insert(0, s.charAt(i + step));
    		step++;
    	}
    	return sb.toString();
    }
    
    private String getEvenStr(String s, int i, int len) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(s.charAt(i));
    	if (i + 1 < len && s.charAt(i + 1) == s.charAt(i)) {
    		sb.append(s.charAt(i));
    		int step = 1;
    		while (i - step >= 0 && i + 1 + step < len && s.charAt(i - step) == s.charAt(i + 1 + step)) {
    			sb.append(s.charAt(i + 1 + step));
    			sb.insert(0, s.charAt(i - step));
    			step++;
    		}
    	}
    	
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome("aabbcc"));
	}

}
