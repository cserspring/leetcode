package manipulation;

/* This is a pure math problem. */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int factor = 5;
        int total = 0;
        while (n > 0) {
        	int count = n / factor;
        	total += count;
        	n = count;
        }
        
        return total;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialTrailingZeroes f = new FactorialTrailingZeroes();
		System.out.print(f.trailingZeroes(30));
	}

}
