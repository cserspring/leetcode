package manipulation;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if ((dividend == Integer.MIN_VALUE && divisor == -1) || divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        long base = b;
        int i = 0;
        long[] nums = new long[32];
        nums[0] = b;
        while (nums[i] <= a && nums[i] > 0) {
        	nums[i+1] = base << (i+1);
        	++i;
        }
        --i;
        
        int cnt = 0;
        while (a > 0 && i >= 0) {
        	while (a - nums[i] >= 0) {
        		a -= nums[i];
        		cnt += (1 << i);
        	}
        	--i;
        }
        
        return ((dividend ^ divisor) >> 31) == 0 ? cnt : -cnt;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(-2147483648,
				2));
	}

}
