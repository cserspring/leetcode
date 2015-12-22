package array;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int n;
        if (nums == null || (n = nums.length) == 0) return 0;

        int start = 0;
        int end = n - 1;
        int index = -1;

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
        
		if (index == -1)
			index = end + 1;
        
		return index;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition s = new SearchInsertPosition();
		int[] nums = { 1, 3, 5 };
		System.out.println(s.searchInsert(nums, 7));
	}

}
