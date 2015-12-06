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
        for (int i = 0; i < len - 2;) {
        	int rem = 0 - nums[i];        	
        	int left = i + 1;
        	int right = len - 1;
        	
        	while (left < right) {
        		if (nums[left] + nums[right] == rem) {
        			List<Integer> subRes = new ArrayList<Integer>();
        			subRes.add(nums[i]);
        			subRes.add(nums[left]);
        			subRes.add(nums[right]);
        			res.add(subRes);
            		
            		do { ++left; } while (left < len && nums[left] == nums[left - 1]);
            		do { --right; } while (right >= 0 && nums[right + 1] == nums[right]);
        		} else if (nums[left] + nums[right] < rem) {
        			left++;
        		} else {
        			right--;
        		}
        	}
        	
        	do { ++i; } while (i < len && nums[i] == nums[i - 1]);
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum t = new ThreeSum();
		int[] S = { -2,0,1,1,2 };
		List<List<Integer>> res = t.threeSum(S);
		for (List<Integer> subRes : res) {
			for (int i : subRes)
				System.out.print(i + "\t");
			System.out.println("\n");
		}
	}

}
