package recursion;

import java.util.Arrays;

public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
    	int m = s1.length();
    	int n = s2.length();
    	if (m != n) return false;
    	char[] c1 = s1.toCharArray();
    	char[] c2 = s2.toCharArray();
    	Arrays.sort(c1);
    	Arrays.sort(c2);
    	if (!isEqual(c1, c2, m)) return false;
    	if (m == 1) return true;
    	for (int i = 1; i < m; ++i) {
    		if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, m), s2.substring(i, m))) return true;
    		if (isScramble(s1.substring(0, i), s2.substring(m - i, m)) && isScramble(s1.substring(i, m), s2.substring(0, m - i))) return true;
    	}
    	return false;
    }
    
    private boolean isEqual(char[] c1, char[] c2, int n) {
    	for (int i = 0; i < n; ++i) {
    		if (c1[i] != c2[i]) return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString s = new ScrambleString();
		System.out.println(s.isScramble("rgtae", "great"));
	}

}
