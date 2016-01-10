package recursion;

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();;
    	List<Integer> row = new ArrayList<Integer>();
    	if (numRows == 1) {     	
        	row.add(1);
        	res.add(row);
    	} else if (numRows > 1){
    		res = generate(numRows - 1);
    		List<Integer> lastRow = res.get(numRows - 2);
    		int size = lastRow.size();
    		for (int i = 0; i < size; ++i) {
    			row.add((i > 0 ? lastRow.get(i - 1) : 0) + lastRow.get(i));
    		}
    		row.add(lastRow.get(size - 1));
    		res.add(row);
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		List<List<Integer>> res = p.generate(5);
		for (List<Integer> row : res) {
			for (int i : row)
				System.out.print(i + " ");
			System.out.println();
		}
	}

}
