package manipulation;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        
    	int n = haystack.length();
    	int m = needle.length();
        int i = 0;
        int j = 0;        
        for (i = 0; i < n - m + 1; ++i) {
        	for (j = 0; j < m; ++j) {
        		if (haystack.charAt(i + j) != needle.charAt(j))
        			break;
        	}
        	
        	if (j == m)
        		return i;
        }
        
        return -1;
    }
        
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcbbbdd";
		String b = "bdd";
		
		ImplementStrStr i = new ImplementStrStr();
		System.out.println(i.strStr(a, b));
	}

}
