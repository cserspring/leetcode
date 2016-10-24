package area;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
    	int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
        	for (int j = 0; j < matrix[i].length; ++j) {
        		if (matrix[i][j] == '1') 
        			max = Math.max(max, getArea(i, j, matrix));
        	}
        }
        
        return max;
    }
    
    private int getArea(int x, int y, char[][] matrix) {
    	int count = 1;
    	for (int i = x + 1, j = y + 1; i < matrix.length && j < matrix[x].length; ++i, ++j) {
    		for (int m = y; m <= j; ++m) {
    			if (matrix[i][m] == '0')
    				return count*count;
    		}
    		
    		for (int n = x; n < i; ++n) {
    			if (matrix[n][j] =='0')
    				return count*count;
    		}
    		
    		++count;
    	}
    	
    	return count*count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { {'1', '0', '1', '0', '0'},
				            {'1', '0', '1', '1', '1'},
		                    {'1', '1', '1', '1', '1'},
		                    {'1', '0', '0', '1', '0'} };
		MaximalSquare m = new MaximalSquare();
		System.out.println(m.maximalSquare(matrix));
	}

}
