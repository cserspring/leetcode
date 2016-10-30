package math;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
    	int count = 0;
        for (int i = 1; i <= n; ++i) {
        	String s = String.valueOf(i);
        	for (int j = 0; j < s.length(); ++j) 
        		if (s.charAt(j) == '1')
        			++count;
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfDigitOne n = new NumberOfDigitOne();
		System.out.println(n.countDigitOne(13));
	}

}
