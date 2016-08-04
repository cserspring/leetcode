package array;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
    	int n;
        if (nums == null || (n = nums.length) == 0) return -1;
        // Remove duplicates
    	int i = 1;
    	int end = 1;
    	while (i < n) {
    		if (nums[i] != nums[end-1]) {
    			nums[end] = nums[i];
    			++end;    			
    		}
    		
    		++i;
    	}
    	
    	--end;
    	if (nums[end] == nums[0])
    		--end;
    	
    	int start = 0;
    	while (start < end) {
    		int mid = start + (end - start) / 2;
    		if (nums[mid] < nums[end])
    			end = mid;
    		else
    			start = mid + 1;
    	}
    	
    	return nums[start];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3};
		FindMinimumInRotatedSortedArrayII f = new FindMinimumInRotatedSortedArrayII();
		System.out.println(f.findMin(nums));
	}

}
