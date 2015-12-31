package array;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
        		if (matrix[i][j] == 0) {
        			if (i == 0) firstRow = true;
        			if (j == 0) firstColumn = true;
        			matrix[i][0] = matrix[0][j] = 0;
        		}
        	}
        }
        
        for (int i = 1; i < m; ++i) {
        	for (int j = 1; j < n; ++j) {
        		if (matrix[i][0] == 0 || matrix[0][j] == 0)
        			matrix[i][j] = 0;
        	}
        }
        
        if (firstRow) {
        	for (int i = 0; i < n; ++i)
        		matrix[0][i] = 0;
        }
        
        if (firstColumn) {
        	for (int i = 0; i < m; ++i)
        		matrix[i][0] = 0;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
		SetMatrixZeroes s = new SetMatrixZeroes();
		s.setZeroes(matrix);
	}

}
