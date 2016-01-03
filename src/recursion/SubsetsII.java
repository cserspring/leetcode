package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> record = new ArrayList<Integer>();
    	Arrays.sort(nums);
    	int n = nums.length;
    	for (int k = 0; k <= n; ++k)
    		generateRecord(res, record, nums, 0, n - 1, k);
    	return res;
    }
    
    private void generateRecord(List<List<Integer>> res, List<Integer> record, int[] nums, int start, int end, int k) {
    	if (k == 0) {
    		res.add(record);
    		return;
    	}
    	
    	for (int i = start; i <= end - k + 1; ++i) { 
    		if (i > start && nums[i] == nums[i - 1]) continue;
    		List<Integer> newRecord = new ArrayList<Integer>(record);
    		newRecord.add(nums[i]);
    		generateRecord(res, newRecord, nums, i + 1, end, k - 1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetsII s = new SubsetsII();
		int[] nums = { 1, 2, 2, 3 };
		List<List<Integer>> res = s.subsetsWithDup(nums);
		for (List<Integer> l : res) {
			for (int i : l) 
				System.out.print(i + "\t");
			System.out.println();
		}
	}

}
