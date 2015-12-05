package sum;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
    	int len = nums.length;
    	int[] res = new int[2];
        for (int i = 0; i < len - 1; ++i) {
        	res[0] = i + 1;
        	int rem = target - nums[i];
        	for (int j = i + 1; j < len; ++j) {
        		if (nums[j] == rem) {
        			res[1] = j + 1;
        			return res;
        		}
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum t = new TwoSum();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res = t.twoSum(nums, target);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

}
