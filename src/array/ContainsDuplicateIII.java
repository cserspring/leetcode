package array;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	int n;
    	if (nums == null || (n = nums.length) == 0 || k <= 0 || t < 0) return false;
    	TreeSet<Integer> set = new TreeSet<Integer>();
    	for (int i = 0; i < n; ++i) {
    		int value = nums[i];
    		Integer v1 = set.floor(value);
    		Integer v2 = set.ceiling(value);
    		if ((v1 != null && value <= v1 + t) || (v2 != null && v2 <= value + t)) 
    			return true;    		
    		
    		set.add(value);
    		if (set.size() > k)
    			set.remove(nums[i-k]);
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1,2147483647 };
		int k = 1;
		int t = 2147483647;
		ContainsDuplicateIII c = new ContainsDuplicateIII();
		System.out.println(c.containsNearbyAlmostDuplicate(nums, k, t));
	}

}
