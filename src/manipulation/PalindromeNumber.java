package manipulation;

public class PalindromeNumber {
    
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
        int y = x;
        int result = 0;
        while (y > 0) {        	
        	result = result * 10 + y % 10;        	
        	y = y / 10;
        }
        
        return x == result;
    }
    
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int a = 1;
        while (x / a >= 10) {
        	a = a * 10;
        }
        
        int left = 0;
        int right = 0;
        while (x > 0 && a > 1) {
        	left = x / a;
        	right = x % 10;
        	if (left != right) return false;
        	x = (x % a) / 10;
        	a = a / 100;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(1234567890));
	}

}
