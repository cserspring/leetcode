package dp;

public class JumpGameII {

    public int jump(int[] nums) {
    	int len; 
    	if ((len = nums.length) == 1) return 0;
    	int count = 0;
    	int start = 0;
    	int end = 0;
    	while (end < len) {
    		int mostRight = 0;
    		++count;
    		for (int j = start; j <= end; ++j) {
    			if (j + nums[j] >= len - 1)
    				return count;
    			if (j + nums[j] > mostRight)
    				mostRight = j + nums[j];
    		}
    		
    		start  = end + 1;
    		end = mostRight;
    	}
    	
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,3,1,1,4 };
		JumpGameII j = new JumpGameII();
		System.out.println(j.jump(nums));
	}

}
