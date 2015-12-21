package string;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 2) return;
        int index1 = -1;
        for (int i = 0; i < len - 1; ++i) {
        	if (nums[i + 1] > nums[i])
        		index1 = i;
        }
        
        if (index1 != -1) {
        	int index2 = index1 + 1;
        	for (int j = index2 + 1; j < len; ++j) {
        		if (nums[j] > nums[index1])
        			index2 = j;
        	}
        	
            swap(nums, index1, index2);
            reverse(nums, index1 + 1, len);
        } else {
        	reverse(nums, 0, len);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int start, int end) {
    	for (int i = start; i < (end - start) / 2 + start; ++i) {
    		swap(nums, i, end - i + start - 1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation n = new NextPermutation();
		int[] nums = { 1,3,2 };
		n.nextPermutation(nums);
		for (int i = 0; i < nums.length; ++i)
			System.out.println(nums[i]);
	}

}
