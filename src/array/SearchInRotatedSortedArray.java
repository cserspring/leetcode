package array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int len = 0;
    	if (nums == null || (len = nums.length) == 0) return 0;
    	// { 0 1 2 4 5 6 7 }
    	// 1. { 6 7 0 1 2 4 5 }
    	// 2. { 2 4 5 6 7 0 1 }
    	int l = 0;
    	int r = len - 1;
    	
    	while (l <= r) {
    		int mid = (r - l) / 2 + l;
        	if (nums[mid] == target) return mid;
        	if (nums[mid] < nums[r]) {
        		if (target > nums[mid] && target <= nums[r])
        			l = mid + 1;
        		else
        			r = mid - 1;
        	} else {
        		if (nums[l] <= target && target < nums[mid]) 
        			r = mid - 1;
        		else
        			l = mid + 1;
        	}
    	}
    	
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		System.out.println(s.search(nums, 2));
	}

}
