package sum;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
    	int len = nums.length;
        Arrays.sort(nums);
        
        int delta = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < len - 2;) {
        	int l = i + 1;
        	int r = len - 1;
        	while (l < r) {
        		int tmp = nums[i] + nums[l] + nums[r] - target;
        		if (Math.abs(tmp) < Math.abs(delta))
        			delta = tmp;
        		if (tmp == 0)
        			return target;
        		if (tmp < 0)
        			++l;
        		else
        			--r;
        	}
        	
        	do { ++i; } while (i < len && nums[i] == nums[i - 1]);
        }
        
        return target + delta;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		ThreeSumClosest t = new ThreeSumClosest();
		System.out.println(t.threeSumClosest(nums, target));
	}

}
