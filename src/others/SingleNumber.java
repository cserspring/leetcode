package others;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
        	res ^= nums[i];
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
