package recursion;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] res = new int[n + 1];
        for (int i = m - 1; i >= 0; --i) {
        	for (int j = 0; j < triangle.get(i).size(); ++j) {
        		res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
        	}
        }
        return res[0];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(triangle));
	}

}
