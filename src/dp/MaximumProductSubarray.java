package dp;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = 0;
        if (nums == null || (n = nums.length) == 0) return 0;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        int ret = nums[0];
        for (int i = 1; i < n; ++i) {
        	max[i] = min[i] = nums[i];
        	if (nums[i] > 0) {
        		max[i] = Math.max(max[i], max[i-1]*nums[i]);
        		min[i] = Math.min(min[i], min[i-1]*nums[i]);
        	} else if (nums[i] < 0) {
        		max[i] = Math.max(max[i], min[i-1]*nums[i]);
        		min[i] = Math.min(min[i], max[i-1]*nums[i]);
        	}
        	
        	ret = Math.max(ret, max[i]);
        }
        
        return ret;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,-2,4};
		MaximumProductSubarray m = new MaximumProductSubarray();
		System.out.println(m.maxProduct(arr));
	}

}
