package string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int len = 0;
    	if (strs == null || (len = strs.length) == 0) return "";

    	StringBuilder sb = new StringBuilder();
        int i = 0;
        int len0 = strs[0].length();
        while (i < len0) {
        	char c = strs[0].charAt(i);
        	for (int j = 1; j < len; ++j) {
        		if (i >= strs[j].length() || strs[j].charAt(i) != c)
        			return sb.toString();
        	}
        	
        	sb.append(c);
        	++i;
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "abc", "ab", "abcd", "abcdef" };
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(strs));
	}

}
