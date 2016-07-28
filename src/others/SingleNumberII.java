package others;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
        	int mask = 1 << i;
        	int count = 0;
        	for (int j = 0; j < n; ++j) 
        		if ((nums[j] & mask) != 0)
        			++count;
        	res += (count % 3) == 0 ? 0 : mask;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,3,3,2,2,2,4};
		SingleNumberII s = new SingleNumberII();
		System.out.println(s.singleNumber(nums));
	}

}
