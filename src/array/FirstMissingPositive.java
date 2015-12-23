package array;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) return 1;
        for (int i = 0; i < n; ++i) {
        	int a = nums[i];
        	while (a > 0 && a <= n && nums[i] != i + 1 && nums[a - 1] != a) {
        		swap(nums, i, a - 1);
        		a = nums[i];
        	}
        }
        
        int j = 0;
        while (j < n && nums[j] == j + 1){
        	++j;
        }
        return j + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,1 };
		FirstMissingPositive f = new FirstMissingPositive();
		System.out.println(f.firstMissingPositive(nums));
	}

}
