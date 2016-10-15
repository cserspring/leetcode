package manipulation;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
    	Set<Integer> set = new HashSet<Integer>();
        return isHappyHelper(n, set);        
    }
    
    private boolean isHappyHelper(int n, Set<Integer> set) {
    	int res = 0;
        while (n != 0) {
        	int remain = n % 10;
        	res = res + remain*remain;
        	n = n / 10;
        }
        
        if (res == 1) return true;
        if (set.contains(res)) return false;
        set.add(res);
        return isHappyHelper(res, set);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber h = new HappyNumber();
		System.out.println(h.isHappy(21));
	}

}
