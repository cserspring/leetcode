package rotation;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rows = n / 2;
        int cols = n - rows;
        for (int i = 0; i < rows; ++i) {
        	for (int j = 0; j < cols; ++j) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[n - 1 - j][i];
        		matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        		matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        		matrix[j][n - 1 - i] = tmp;
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
