package array;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) <= 0) return -1;
        int start = 0; 
        int end = n - 1;
        int mid = start;
        while (start <= end) {
        	mid = start + (end - start) / 2;
        	if((mid == 0 || nums[mid] >= nums[mid - 1]) &&
                    (mid == n - 1 || nums[mid] >= nums[mid + 1])) {
                         return mid;
        	} else if (mid > 0 && nums[mid] < nums[mid - 1]) {
        		end = mid-1;
        	} else {
        		start = mid+1;
        	}
        }
        
        return mid;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
