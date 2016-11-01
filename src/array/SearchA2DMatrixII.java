package array;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m;
        int n;
        if (matrix == null || (m = matrix.length) == 0) return false;
        if (matrix[0] == null || (n = matrix[0].length) == 0) return false;
        int x = m - 1;
        int y = 0;
        // From bottom-left to top-right
        while (x >= 0 && y < n) {
        	if (matrix[x][y] == target)
        		return true;
        	if (matrix[x][y] < target) {
        		++y;        		
        	} else {
        		--x;
        	}
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
