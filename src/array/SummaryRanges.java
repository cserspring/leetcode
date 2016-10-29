package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int n;
        List<String> res = new ArrayList<String>();
        if (nums == null || (n = nums.length) == 0) return res;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < n; ++i) {
        	if (nums[i] != nums[i-1] + 1) {
        		end = nums[i-1];
        		addResult(res, start, end);
        		start = nums[i];
        	}
        }
        
        addResult(res, start, nums[n-1]);        
        return res;
    }
    
    private void addResult(List<String> res, int start, int end) {
    	if (start == end) {
			res.add(String.valueOf(end));
		} else {
			res.add(String.valueOf(start) + "->" + String.valueOf(end));
		}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummaryRanges s = new SummaryRanges();
		int[] nums = {0,1,2,4,5,7};
		List<String> res = s.summaryRanges(nums);
		for (String str : res) {
			System.out.println(str);
		}
	}

}
