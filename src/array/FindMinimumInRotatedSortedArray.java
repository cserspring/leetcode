package array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) return -1;
        int start = 0;
        int end = n - 1;
        while (start < end) {
        	int mid = start + (end - start) / 2;
        	if (nums[mid] < nums[end]) {
        		end = mid;
        	} else {
        		start = mid + 1;
        	}
        }
        
        return nums[start];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
