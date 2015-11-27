package dp;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        return Math.max(rob(nums, 1, len - 1), rob(nums, 0, len - 2));
    }
    
    private int rob(int[] nums, int start, int end) {
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	for (int i = start; i <= end; ++i) {
    		c = Math.max(b, a + nums[i]);
    		a = b;
    		b = c;
    	}
    	
    	return c;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,1 };
		HouseRobberII h = new HouseRobberII();
		System.out.println(h.rob(nums));
	}

}
