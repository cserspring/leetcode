package array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = -1;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
        	if (count == 0) {
        		res = nums[i];
        		++count;
        	} else if (res == nums[i]) {
        		++count;
        	} else {
        		--count;
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
