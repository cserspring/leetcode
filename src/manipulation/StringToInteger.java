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
        
        while (pos < len && Character.isDigit(str.charAt(pos))){
        	int value = str.charAt(pos) - '0';
        	int preRes = res;
        	res = Math.abs(res) * 10 * sign;
        	if (res/(10 * sign) != Math.abs(preRes)) {
        		return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	}
        	
        	preRes = res;
        	res = res + sign * value;
        	if (sign == 1 && res < preRes)
        		return Integer.MAX_VALUE;
        	if (sign == -1 && res > preRes)
        		return Integer.MIN_VALUE;
        	++pos;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "-123";
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.myAtoi(str));
	}

}
