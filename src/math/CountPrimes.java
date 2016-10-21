package math;

public class CountPrimes {
    public int countPrimes(int n) {
    	int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; ++i) flag[i] = true;
        for (int i = 2; i <= n/i; ++i) {
        	if (!flag[i]) continue;
        	for (int j = i * i; j < n; j = j + i) {
        		flag[j] = false;
        	}
        }
        
        for (int i = 2; i < n; ++i) 
        	if (flag[i])
        		++count;
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrimes c = new CountPrimes();
		System.out.println(c.countPrimes(5));
	}

}
