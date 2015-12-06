package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	int len;    	
        if (nums == null || (len = nums.length) < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; ++i) {
        	int rem = 0 - nums[i];
        	List<Integer> subRes = new ArrayList<Integer>();
        	subRes.add(nums[i]);
        	GetTwo(rem, i + 1, nums, len, subRes, res);
        	// Move forward if next element is the same as current element
        	while (i < len - 1 && nums[i+1] == nums[i]) ++i;
        }
        
        return res;
    }
    
    private void GetTwo(int rem, int start, int[] nums, int len, List<Integer> subRes, List<List<Integer>> res) {
    	for (int i = start; i < len - 1; ++i) {
    		int last = rem - nums[i];
    		List<Integer> cpySubRes = new ArrayList<Integer>(subRes);
    		cpySubRes.add(nums[i]);
    		GetLast(last, i + 1, nums, len, cpySubRes, res);
    		// Move forward if next element is the same as current element
    		while (i < len - 1 && nums[i+1] == nums[i]) ++i;
    	}
    }
    
    private void GetLast(int rem, int start, int[] nums, int len, List<Integer> subRes, List<List<Integer>> res) {
    	for (int i = start; i < len; ++i) {
    		if (rem == nums[i]) {
    			subRes.add(nums[i]);
    			res.add(subRes);
    			break;
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum t = new ThreeSum();
		int[] S = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = t.threeSum(S);
		for (List<Integer> subRes : res) {
			for (int i : subRes)
				System.out.print(i + "\t");
			System.out.println("\n");
		}
	}

}
