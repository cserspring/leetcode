package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> record = new ArrayList<Integer>();
        combine(candidates, 0, candidates.length, res, record, target);
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
    			combine(nums, i + 1, end, res, newRecord, target);
    		} else if (rem < 0) {
    			break;
    		}
    		
    		while (i + 1 < end && nums[i + 1] == nums[i]) ++i;
    	}
    }
    
    private int sum(List<Integer> record) {
    	int sum = 0;
    	for (int i : record)
    		sum += i;
    	return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10,1,2,7,6,1,5 };
		CombinationSumII c = new CombinationSumII();
		List<List<Integer>> res = c.combinationSum2(nums, 8);
		for (List<Integer> l : res) {
			for (int i : l)
				System.out.print(i + "\t");
			System.out.println();
		}
	}

}
