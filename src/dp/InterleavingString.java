package dp;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1 + len2) return false;
        char[] c12 = (s1 + s2).toCharArray();
        Arrays.sort(c12);
        char[] c3 = s3.toCharArray();
        Arrays.sort(c3);
        if (!isEqual(c12, c3, len3)) return false;
        return interleave(s1, s2, s3, len1, len2, len3, 0, 0, 0);
    }
    
    private boolean interleave(String s1, String s2, String s3, int len1, int len2, int len3, int i, int j, int k) {
    	if (i == len1 && j == len2 && k == len3) return true;
    	boolean flag = false;
    	if (i < len1 && s1.charAt(i) == s3.charAt(k))
    		flag = flag || interleave(s1, s2, s3, len1, len2, len3, i + 1, j, k + 1);
    	if (j < len2 && s2.charAt(j) == s3.charAt(k))
    		flag = flag || interleave(s1, s2, s3, len1, len2, len3, i, j + 1, k + 1);
    	return flag;
    }
    
    private boolean isEqual(char[] c0, char[] c1, int n) {
    	for (int i = 0; i < n; ++i) {
    		if (c0[i] != c1[i])
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString i = new InterleavingString();
		System.out.println(i.isInterleave("a", "b", "ab"));
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
