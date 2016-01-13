package recursion;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        return minPath(triangle, 0, 0, m, 0);
    }
    
    private int minPath(List<List<Integer>> triangle, int row, int col, int m, int prevTotal) {
    	if (row >= m) return prevTotal;
    	prevTotal += triangle.get(row).get(col);
    	return Math.min(minPath(triangle, row + 1, col, m, prevTotal), minPath(triangle, row + 1, col + 1, m, prevTotal));
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
