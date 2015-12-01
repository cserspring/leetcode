package dp;

public class JumpGame {

    public boolean canJump(int[] nums) {
    	int len = nums.length;
    	int max = 0;
    	for (int i = 0; i < len - 1; ++i) {
    		if (i + nums[i] > max)
    			max = i + nums[i];
    		if (nums[i] == 0 && i >= max)
    			return false;
    	}
    	
    	return max >= len - 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2,3,1,1,4};
		int[] nums2 = {0,3,2};
		
		JumpGame j = new JumpGame();
		System.out.println(j.canJump(nums1));
		System.out.println(j.canJump(nums2));
	}

}
