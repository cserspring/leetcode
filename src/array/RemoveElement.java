package array;

public class RemoveElement {
	
    public int removeElement(int[] nums, int val) {
        return partition (nums, 0, nums.length - 1, val);
    }
    
    private int partition (int[] nums, int start, int end, int pivot) {
    	int i = end;
    	for (int j = end; j >= start; --j) {
    		if (nums[j] == pivot) {    			
    			int tmp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = tmp;
    			--i;
    		}
    	}
    	return i + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 4, 5, 2, 2, 1, 2, 9, 2, 10, 2 };
		RemoveElement r = new RemoveElement();
		System.out.println(r.removeElement(nums, 3));
	}

}
