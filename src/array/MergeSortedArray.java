package array;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; --i) {
        	if (m > 0 && n > 0)
        		nums1[i] = nums1[m - 1] > nums2[n - 1] ? nums1[m-- - 1] : nums2[n-- - 1];
        	else if (m > 0)
        		nums1[i] = nums1[m-- -1];
        	else
        		nums1[i] = nums2[n-- -1];
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1,3,5,7,9,11,13,15,17,19 };
		int[] nums2 = { 2,4,6,8,10 };
		MergeSortedArray m = new MergeSortedArray();
		m.merge(nums1, 5, nums2, 5);
	}

}
