package math;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n;
        if (nums == null || ((n = nums.length) == 0)) return new int[0];
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; ++i) {
        	res[i] = res[i-1] * nums[i];
        }
        
        int right = 1;
        for (int i = n - 1; i > 0; --i) {
        	res[i] = res[i-1] * right;
        	right *= nums[i];

        }
        
        res[0] = right;        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
		int[] nums = {2,3};
		int[] res = p.productExceptSelf(nums);
		for (int i : res)
			System.out.println(i);
	}

}
