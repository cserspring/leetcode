package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	int[] positions = new int[n];
    	solve(positions, res, 0, n);
    	return res;
    }
    
    private void solve(int[] positions, List<List<String>> res, int row, int n) {
    	if (row == n) {
    		List<String> record = new ArrayList<String>();
    		for (int i = 0; i < n; ++i) {    			
    			StringBuilder sb = new StringBuilder();
    			for (int j = 0; j < n; ++j)
    				sb.append('.');
    			sb.setCharAt(positions[i], 'Q');
    			record.add(sb.toString());
    		}
			res.add(record);
    	} else {
    		for (int i = 0; i < n; ++i) {
    			if (isValid(positions, row, i)) {
    				positions[row] = i;
    				solve(positions, res, row + 1, n);
    			}
    		}
    	}
    }
    
    private boolean isValid(int[] positions, int row, int candidate) {
    	for (int i = 0; i < row; ++i) {
    		if (positions[i] == candidate || Math.abs(i - row) == Math.abs(positions[i] - candidate))
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens n = new NQueens();
		List<List<String>> res = n.solveNQueens(4);
		for (List<String> subRes : res) {
			for (String s : subRes)
				System.out.print(s + "\t");
			System.out.println("\n");
		}
	}

}
