package array;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n;
    	if (nums == null || (n = nums.length) == 0) return 0;
    	int max = nums[0];
    	int leftSum = nums[0];
    	for (int i = 1; i < n; ++i) {
    		if (nums[i] >= 0) {
    			if (leftSum >= 0) {
    				leftSum += nums[i];    				
    			} else {
    				leftSum = nums[i];
    			}
    			
    			if (max < leftSum)
					max = leftSum;
    		} else {
    			if (leftSum + nums[i] >= 0) {
    				leftSum += nums[i];
    			} else {
    				leftSum = nums[i];
    			}
    			
    			if (max < leftSum)
    				max = leftSum;
    		}
    	}
    	
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { /*-2,1,-3,4,-1,2,1,-5,4*/ -2, -1 };
		MaximumSubarray m = new MaximumSubarray();
		System.out.println(m.maxSubArray(nums));
	}

}
