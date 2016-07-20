package array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
        	set.add(i);
        }
        
        int max = 0;
        for (int i : nums) {
        	max = Math.max(max, GetLength(set, i));
        }
        
        return max;
    }
    
    private int GetLength(HashSet<Integer> set, int val) {
    	if (!set.contains(val)) return 0;
    	int len = 1;
    	set.remove(val);
    	int left = val - 1;
    	while (set.contains(left)) {
    		set.remove(left);
    		--left;
    		++len;
    	}
    	
    	int right = val + 1;
    	while (set.contains(right)) {
    		set.remove(right);
    		++right;
    		++len;
    	}
    	
    	return len;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence l = new LongestConsecutiveSequence();
		int[] arr = {100, 4, 200, 1, 3, 2};
		System.out.println(l.longestConsecutive(arr));
	}

}
