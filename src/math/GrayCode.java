package math;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (n < 0) return res;
    	res.add(0);
    	int count = 0;
    	while (count < n) {
    		for (int i = res.size() - 1; i >= 0; --i) {
    			res.add(res.get(i) + (1 << count));
    		}
    		++count;
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode g = new GrayCode();
		for (int i : g.grayCode(3))
			System.out.println(i);
	}

}
