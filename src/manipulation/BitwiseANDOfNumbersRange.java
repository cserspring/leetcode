package manipulation;

public class BitwiseANDOfNumbersRange {
	// Look for the left most common part.
    public int rangeBitwiseAnd(int m, int n) {
    	int count = 0;
    	while (m != n) {
    		m = m >> 1;
    		n = n >> 1;
    		++count;
    	}
    	
    	return m << count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseANDOfNumbersRange b = new BitwiseANDOfNumbersRange();
		System.out.println(b.rangeBitwiseAnd(5, 7));
	}

}
