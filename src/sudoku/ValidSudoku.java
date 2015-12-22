package sudoku;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
    	for (int i = 0; i < n; ++i) {
            int[] arr = new int[10];
    		for (int j = 0; j < n; ++j) {
    			if (board[i][j] != '.')
    				arr[board[i][j] - '0']++;
    		}
    		if (!validate(arr))
    			return false;
    	}
    	
    	for (int i = 0; i < n; ++i) {
    		int[] arr = new int[10];
    		for (int j = 0; j < n; ++j) {
    			if (board[j][i] != '.')
    				arr[board[j][i] - '0']++;
    		}
    		if (!validate(arr))
    			return false;
    	}
    	
    	for (int i = 0; i < n; i += 3) {
    		for (int j = 0; j < n; j += 3) {
    			int[] arr = new int[10];
    			for (int x = i; x < i + 3; ++x) {
    				for (int y = j; y < j + 3; ++y) {
    					if (board[x][y] != '.') 
    						arr[board[x][y] - '0']++;
    				}
    			}
    			if (!validate(arr))
    				return false;
    		}
    	}
    	
    	return true;
    }
    
    private boolean validate(int[] arr) {
    	for (int i = 1; i < 10; ++i) {
    		if (arr[i] > 1)
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
