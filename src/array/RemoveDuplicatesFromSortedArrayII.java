package array;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2) return len;
        int start = 1;
        for (int i = 2; i < len; ++i) {
        	if (nums[i] != nums[start] || nums[start] != nums[start - 1])
        	{	
        		++start;
        		nums[start] = nums[i];
        	}
        }
        return start + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,1,1,2,2,3 };
		RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
		System.out.println(r.removeDuplicates(nums));
	}

}
