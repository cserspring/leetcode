package math;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
    	if (n <= 0) return false;
    	while (n != 1) {
    		if (n % 2 != 0) return false;
    		n = n / 2;
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerOfTwo p = new PowerOfTwo();
		for (int i = -1; i < 17; ++i)
			System.out.println(i + " -> " + p.isPowerOfTwo(i));
	}

}
