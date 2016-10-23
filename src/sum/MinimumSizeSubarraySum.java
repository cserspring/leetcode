package sum;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) return 0;
        int cpys = s;
        for (int i = 0; i < n; ++i) {
        	cpys -= nums[i];
        }
        
        if (cpys > 0) return 0;
        
        int min = Integer.MAX_VALUE;
        int count = 0;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < n; ++i) {
        	sum += nums[i];
        	++count;
        	while (sum >= s) {
        		min = Math.min(count, min);
        		sum -= nums[start];
        		--count;
        		++start;
        	}
        }
        
        return min;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		System.out.println(m.minSubArrayLen(s, nums));
	}

}
