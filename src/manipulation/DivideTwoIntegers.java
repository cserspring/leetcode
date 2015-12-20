package manipulation;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if ((dividend == Integer.MIN_VALUE && divisor == -1) || divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int delta = a - b;
        int cnt = 0;
        while (delta > 0) {
        	++cnt;
        	delta = delta - b;
        }
        
        return cnt;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
