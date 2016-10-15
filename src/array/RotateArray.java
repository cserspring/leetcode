package array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
    	int n;
        if (nums == null || (n = nums.length) == 0) return;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
    	while (start < end) {
    		int tmp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = tmp;
    		++start;
    		--end;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		RotateArray r = new RotateArray();
		r.rotate(arr, 2);
		for (int i = 0; i < arr.length; ++i)
			System.out.println(arr[i]);
	}

}
