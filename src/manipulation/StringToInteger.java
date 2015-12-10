package manipulation;

public class StringToInteger {

    public int myAtoi(String str) {
        int len;
    	if (str == null || (len = str.length()) == 0) return 0;
        int pos = 0;
        int sign = 1;
        int res = 0;
        while (Character.isWhitespace(str.charAt(pos))) ++pos;
        if (str.charAt(pos) == '+') {
        	++pos;
        } else if (str.charAt(pos) == '-') {
        	++pos;
        	sign = -1;
        }
        
        while (pos < len && Character.isDigit(str.charAt(pos))) {
        	int value = str.charAt(pos) - '0';
        	if (sign == 1 && res > (Integer.MAX_VALUE - value) / 10) 
        			return Integer.MAX_VALUE;        	
        	
        	if (sign == -1 && (-res < (Integer.MIN_VALUE + value) / 10)) 
        			return Integer.MIN_VALUE;        	
        
        	res = res * 10 + value;
        	++pos;
        }
        
        return sign > 0 ? res : -res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "-2147483648";
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.myAtoi(str));
		// -(INT_MIN_VALUE) is still INT_MIN_VALUE 
		int x = -2147483648;
		System.out.println(-x);
	}

}
