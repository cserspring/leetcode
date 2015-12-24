package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> subRes = new ArrayList<Integer>();
        subRes.add(nums[0]);
        res.add(subRes);
        return permute(res, nums, 1);
    }
    
    private List<List<Integer>> permute(List<List<Integer>> res, int[] nums, int pos) {
    	if (pos >= nums.length) return res;
    	List<List<Integer>> newRes = new ArrayList<List<Integer>>();
        for (List<Integer> subRes : res) {
        	int count = subRes.size();
        	for (int i = 0; i <= count; ++i) {
        		if (i < count && nums[pos] == subRes.get(i))
        			continue;
        		List<Integer> newSubRes = new ArrayList<Integer>(subRes);
        		newSubRes.add(i, nums[pos]);
        		if (!contains(newRes, newSubRes))
        			newRes.add(newSubRes);
        	}
    	}
        return permute(newRes, nums, pos + 1);
    }
    
    private boolean contains(List<List<Integer>> res, List<Integer> subRes) {
    	for (List<Integer> l : res) {
    		int i = 0;
    		for (; i < subRes.size(); ++i) {
    			if (l.get(i) != subRes.get(i))
    				break;
    		}
    		if (i == subRes.size())
    			return true;
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationsII p = new PermutationsII();
		int[] nums = { 2,2,1,1 };
		List<List<Integer>> res = p.permuteUnique(nums);
		for (List<Integer> l : res) {
			for (int i : l)
				System.out.print(i + "\t");
			System.out.println();
		}
	}

}
