package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
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
        		List<Integer> newSubRes = new ArrayList<Integer>(subRes);
        		newSubRes.add(i, nums[pos]);
        		newRes.add(newSubRes);
        	}
    	}
        return permute(newRes, nums, pos + 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		int[] nums = { 1,1,1 };
		List<List<Integer>> res = p.permute(nums);
		for (List<Integer> l : res) {
			for (int i : l)
				System.out.print(i + "\t");
			System.out.println();
		}
	}

}
