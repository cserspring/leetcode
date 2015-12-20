package array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2) return len;
        int pos = 1;
        for (int i = 1; i < len; ++i) {
        	if (nums[i] != nums[i - 1])
        		nums[pos++] = nums[i];
        }
        
        return pos;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
