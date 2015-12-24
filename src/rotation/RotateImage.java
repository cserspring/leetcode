package rotation;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rows = n / 2;
        int cols = n % 2 == 0 ? rows : (rows + 1);
        int[][] tmp = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
        	for (int j = 0; j < cols; ++j) {
        		tmp[i][j] = matrix[i][j];
        	}
        }
        
        for (int i = rows; i < n; ++i) {
        	for (int j = 0; j < cols; ++j) {
        		matrix[j][n - 1 - i] = matrix[i][j];
        	}
        }
        
        for (int i = cols; i < n; ++i) {
        	for (int j = rows; j < n; ++j) {
        		matrix[j][n - 1 - i] = matrix[i][j];
        	}
        }
        
        for (int i = 0; i < cols; ++i) {
        	for (int j = cols; j < n; ++j) {
        		matrix[j][n - 1 - i] = matrix[i][j];
        	}
        }
        
        for (int i = 0; i < rows; ++i) {
        	for (int j = 0; j < cols; ++j) {
        		matrix[j][n - 1 - i] = tmp[i][j];
        	}
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] matrix = {{1,2,3},{5,6,7},{9,10,11}};
		int[][] matrix = {{1,2},{3,4}};
		RotateImage r = new RotateImage();
		r.rotate(matrix);
	}

}
