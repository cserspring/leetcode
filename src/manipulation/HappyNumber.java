package manipulation;

public class HappyNumber {
    public boolean isHappy(int n) {
        return isHappyHelper(n, 0);        
    }
    
    private boolean isHappyHelper(int n, int loop) {
    	int res = 0;
        while (n != 0) {
        	int remain = n % 10;
        	res = res + remain*remain;
        	n = n / 10;
        }
        
        if (res == 1) return true;
        if (loop > 10) return false;
        return isHappyHelper(res, ++loop);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber h = new HappyNumber();
		System.out.println(h.isHappy(21));
	}

}
