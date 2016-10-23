package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    	int n;
    	if (nums == null || (n = nums.length) == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
        	// add function will return false if the element is already in the set.
        	if (!set.add(nums[i])) return true;
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicate c = new ContainsDuplicate();
		System.out.println(c.containsDuplicate(null));
	}

}
