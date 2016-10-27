package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
    	int n;
    	List<Integer> res = new ArrayList<Integer>();
        if (nums == null || (n = nums.length) == 0) return res;
        Integer v1 = null;
        Integer v2 = null;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < n; ++i) {
        	if (v1 != null && v1 == nums[i]) {
        		++c1;
        	} else if (v2 != null && v2 == nums[i]) {
        		++c2;
        	} else if (c1 == 0) {
        		v1 = nums[i];
        		++c1;
        	} else if (c2 == 0) {
        		v2 = nums[i];
        		++c2;
        	} else {
        		--c1;
        		--c2;
        	}
        }
        
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
        	if (nums[i] == v1)
        		++n1;
        	else if (nums[i] == v2) 
        		++n2;
        }
        
        if (n1 > n/3) res.add(v1);
        if (n2 > n/3) res.add(v2);
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,3,3,2,2,2};
		MajorityElementII m = new MajorityElementII();
		List<Integer> res = m.majorityElement(A);
		for (int i : res) {
			System.out.println(i);
		}
	}

}
