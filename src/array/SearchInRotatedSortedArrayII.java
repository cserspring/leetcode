package array;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) return false;
        for (int i = 0; i < len; ++i) 
        	if (nums[i]==target)
        		return true;
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 1 };
		SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
		System.out.println(s.search(nums, 3));
	}

}
