package array;

// Time complexity n + n / 2 + n / 4 + n / 8 + n / 16 + ... = n (1 + 1/2 + 1/4 + 1/8 + ...) = 2n
public class KthLargestElementInAnArray {
	
	public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len - 1, k);
    }
	
	private int quickSelect(int[] nums, int start, int end, int k) {
		if (start < end) {
			int pivotPosition = partition(nums, start, end);
			if (pivotPosition == k - 1)
				return nums[pivotPosition];
			else if (pivotPosition > k - 1)
				return quickSelect(nums, start, pivotPosition - 1, k);
			else
				return quickSelect(nums, pivotPosition + 1, end, k);
		}
		
		return nums[start];
	}
	
	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start - 1;
		for (int j = start; j < end; ++j) {
			if (nums[j] > pivot) {
				++i;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		
		nums[end] = nums[i + 1];
		nums[i + 1] = pivot;
		return i + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
		int[] nums = {3, 2, 1, 5, 6, 4};
		System.out.println(obj.findKthLargest(nums, 6));
	}

}
