package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = removeDuplicates(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> record = new ArrayList<Integer>();
        combine(candidates, 0, len, res, record, target);
        return res;
    }
    
    private void combine(int[] nums, int start, int end, List<List<Integer>> res, List<Integer> record, int target) {
    	for (int i = start; i < end; ++i) {
    		List<Integer> newRecord = new ArrayList<Integer>(record);
    		newRecord.add(nums[i]);
    		int sum = sum(newRecord);
    		int rem = target - sum;
    		if (rem == 0) {
    			res.add(newRecord);
    		} else if (rem > 0 && rem >= nums[i]) {
    			combine(nums, i, end, res, newRecord, target);
    		} else if (rem < 0) {
    			break;
    		}
    	}
    }
    
    private int sum(List<Integer> record) {
    	int sum = 0;
    	for (int i : record)
    		sum += i;
    	return sum;
    }
    
    private int removeDuplicates(int[] nums) {
    	int n = nums.length;
    	int j = 0;
    	for (int i = 1; i < n; ++i) {
    		if (nums[i] != nums[i - 1]) {
    			nums[++j] = nums[i];
    		}
    	}
    	
    	return j + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {  1, 2, 2, 3, 6, 7 };
		CombinationSum c = new CombinationSum();
		List<List<Integer>> res = c.combinationSum(nums, 7);
	}

}
