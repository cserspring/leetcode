package recursion;

public class NQueensII {
	private int count;
	
    public int totalNQueens(int n) {
    	int[] positions = new int[n];
    	this.count = 0;
    	solve(positions, 0, n);
    	return this.count;
    }
    
    private void solve(int[] positions, int row, int n) {
    	if (row == n) {
    		this.count++;
    	} else {
    		for (int i = 0; i < n; ++i) {
    			if (isValid(positions, row, i)) {
    				positions[row] = i;
    				solve(positions, row + 1, n);
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
		NQueensII n = new NQueensII();
		System.out.println(n.totalNQueens(4));
	}

}
