package sort;

public class SortColors {

    public void sortColors(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 2) return;
        int zeroIndex = 0;
        int twoIndex = n - 1;
        for (int i = 0; i <= twoIndex; ++i) {
        	if (nums[i] == 0) {
        		swap(nums, i, zeroIndex);
        		++zeroIndex;
        	} else if (nums[i] == 2) {
        		swap(nums, i, twoIndex);
        		--twoIndex;
        		--i;
        	}
        }
    }
    
    private void swap(int[] A, int i, int j) {
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 1, 0, 1, 2, 0, 0, 2, 1, 1, 2, 0 };
		SortColors s = new SortColors();
		s.sortColors(A);
		for (int i : A)
			System.out.println(i);
	}

}
