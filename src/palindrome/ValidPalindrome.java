package palindrome;

public class ValidPalindrome {
	
    public boolean isPalindrome(String s) {
    	int n;
        if (s == null || (n = s.length()) == 0) return true;
        int i = 0; 
        int j = n - 1;
        while (i < j) {
        	if (!isAlphanumeric(s.charAt(i))){
        		++i;
        		continue;
        	}
        	
        	if (!isAlphanumeric(s.charAt(j))){
        		--j;
        		continue;
        	}
        	
        	if (!equal(s.charAt(i), s.charAt(j))) return false;
        	++i;
        	--j;
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
    	if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')) return true;
    	return false;
    }
    
    private boolean equal(char a, char b) {
    	int delta = 'a' - 'A';
    	if (a <= 'Z' && a >= 'A')
    		a = (char)(a + delta);
    	if (b <= 'Z' && b >= 'A')
    		b = (char)(b + delta);
    	return a == b;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
