package array;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int n;
        if (nums == null || (n = nums.length) == 0) return res;
        
        int index = -1;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
        	int mid = (end - start) / 2 + start;
        	if (nums[mid] == target) {
        		index = mid;
        		break;
        	} else if (nums[mid] < target) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        
       	res[0] = index;
       	res[1] = index;
       	while (res[0] > 0 && nums[res[0] - 1] == target) --res[0];
       	while (res[1] < n - 1 && nums[res[1] + 1] == target) ++res[1];
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		SearchForARange s = new SearchForARange();
		for(int i : s.searchRange(nums, 10))
		System.out.println(i);
	}

}
