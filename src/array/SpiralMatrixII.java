package array;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	int num = 0;
        for (int i = 0; i < n; ++i) {
        	for (int j = i; j < n -i; ++j) {
        		matrix[i][j] = ++num;
        	}
        	for (int j = i + 1; j < n -i; ++j) {
        		matrix[j][n - i - 1] = ++num;
        	}
        	for (int j = n - i - 2; j >= i; --j) {
        		matrix[n - i - 1][j] = ++num;
        	}
        	for (int j = n - i - 2; j >= i + 1; --j) {
        		matrix[j][i] = ++num;
        	}
        }
        
        return matrix;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrixII s = new SpiralMatrixII();
		int n = 1;
		int[][] matrix = s.generateMatrix(n);
		for (int i = 0; i < n; ++i) {			
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
