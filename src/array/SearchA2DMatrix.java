package array;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m;
        int n;
        if (matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) return false;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
        	int mid = (end - start) / 2 + start;
        	int i = mid / n;
        	int j = mid - i * n;
        	if (matrix[i][j] == target)
        		return true;
        	if (matrix[i][j] < target)
        		start = mid + 1;
        	else
        		end = mid - 1;
        }
        
        return false;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] matrix = {
    	                  { 1, 3, 5, 7 },
    	                  { 10, 11, 16, 20 },
    	                  { 23, 30, 34, 50}
    					};
    	SearchA2DMatrix s = new SearchA2DMatrix();
    	System.out.println(s.searchMatrix(matrix, 8));
	}

}
