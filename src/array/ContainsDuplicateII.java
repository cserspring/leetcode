package array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	int n;
    	if (nums == null || (n = nums.length) == 0) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
        	if (map.containsKey(nums[i])) {
        		int prev = map.get(nums[i]);
        		if (i - prev <= k)
        			return true;
        	}
        	
    		map.put(nums[i], i);
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
