package math;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
    	int count = 0;
        for (int i = 1; i <= n; ++i) {
        	count += numOfDigitOne(i);
        }
        
        return count;
    }
    
    private int numOfDigitOne(int n) {
    	int count = 0;
    	while (n > 0) {
    		if (n % 10 == 1) ++count;
    		n = n / 10;
    	}
    	
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfDigitOne n = new NumberOfDigitOne();
		System.out.println(n.countDigitOne(824883294));
	}

}
