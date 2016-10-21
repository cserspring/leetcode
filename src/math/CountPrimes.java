package math;

public class CountPrimes {
    public int countPrimes(int n) {
    	int count = 0;
        for (int i = 2; i < n; ++i) {
        	if (isPrime(i)) ++count;
        }
        
        return count;
    }
    
    private boolean isPrime(int n) {
    	if (n <= 1) return false;
    	if (n == 2 || n == 3) return true;
    	if (n % 2 == 0 || n % 3 == 0) return false;
    	for (int i = 3; i * i <= n; i = i + 2) {
    		if (n % i == 0) return false;
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
