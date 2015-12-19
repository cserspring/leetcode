package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || (len = nums.length) < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len; ++i) {
        	List<Integer> subRes = new ArrayList<Integer>();
        	subRes.add(nums[i]);
        	getOtherThree(res, subRes, nums, i + 1, len, target);
        	while (i + 1 < len && nums[i + 1] == nums[i]) ++i;
        }
        
        return res;
    }
    
    private void getOtherThree(List<List<Integer>> res, List<Integer> subRes, int[] nums, int start, int len, int target) {
    	for (int i = start; i < len; ++i) {
    		List<Integer> copySubRes = new ArrayList<Integer>(subRes);
    		copySubRes.add(nums[i]);
    		getOtherTwo(res, copySubRes, nums, i + 1, len, target);
    		while (i + 1 < len && nums[i + 1] == nums[i]) ++i;
    	}
    }
    
    private void getOtherTwo(List<List<Integer>> res, List<Integer> subRes, int[] nums, int start, int len, int target) {
    	int sum = 0;
    	for (int i : subRes) sum += i;
    	int rem = target - sum;
    	
    	int left = start;
    	int right = len - 1;
    	while (left < right) {
    		if (nums[left] + nums[right] == rem) {
    			List<Integer> copySubRes = new ArrayList<Integer>(subRes);
        		copySubRes.add(nums[left]);
        		copySubRes.add(nums[right]);
        		res.add(copySubRes);
        		do { ++left; } while (left < len && nums[left - 1] == nums[left]);
        		do { --right; } while (right >=0 && nums[right + 1] == nums[right]);
    		} else if (nums[left] + nums[right] < rem) {
    			++left;
    		} else {
    			--right;
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0,0,4,-2,-3,-2,-2,-3 };
		FourSum f = new FourSum();
		List<List<Integer>> res = f.fourSum(nums, -1);
		for (List<Integer> l : res) {
			for (int i : l)
				System.out.print(i + "\t");
			System.out.println();
		}
	}

}
