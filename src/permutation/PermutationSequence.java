package permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
    	List<Integer> l = new ArrayList<Integer>();
        for (int i = 1; i <= n; ++i) 
        	l.add(i);
        --k;
    	StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; --i) {
        	int fib = fib(i - 1);
        	int index = k / fib;
        	k = k % fib;
        	sb.append((char)('0' + l.get(index)));
        	l.remove(index);
        }
        return sb.toString();
    }
    
    private int fib(int n) {
    	int res = 1;
    	for (int i = 1; i <= n; ++i)
    		res *= i;
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(4, 5));
	}

}
