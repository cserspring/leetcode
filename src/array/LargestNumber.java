package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
        	list.add(String.valueOf(nums[i]));
        }
        
        Collections.sort(list, new Comparator<String>(){
        	public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        if (list.get(n-1).equals("0")) return "0";
        String ans = "";
        for (int i = n-1; i >= 0; --i) {
        	ans += list.get(i);
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 30, 34, 5, 9};
		LargestNumber l = new LargestNumber();
		System.out.println(l.largestNumber(nums));
	}

}
