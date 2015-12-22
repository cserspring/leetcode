package sudoku;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
    	solve(board);
    }
    
    private boolean solve(char[][] board) {
    	int m = -1;
    	int n = -1;
    	for (int i = 0; i < 9; ++i) {
    		for (int j = 0; j < 9; ++j) {
    			if (board[i][j] == '.') {
    				m = i;
    				n = j;
    				break;
    			}
    		}
    	}
    	
    	if (m == -1 && n == -1) {
    		return true;
    	}
    	
    	for (int k = 1; k <= 9; ++k) {
    		board[m][n] = (char)('0' + k);
    		if (validate(board, m, n) && solve(board))
    			return true;
    		board[m][n] = '.';
    	}
    	
    	return false;
    }
    
    private boolean validate(char[][] board, int x, int y) {
    	for (int i = 0; i < 9; ++i) {
    		if (i != y &&board[x][i] == board[x][y])
    			return false;
    		
    		if (i != x && board[i][y] == board[x][y]) 
    			return false;
    	}
    	
    	int m = x / 3;
    	int n = y / 3;
    	for (int i = 3*m; i < 3*m + 3; ++i) {
    		for (int j = 3*n; j < 3*n + 3; ++j) {
    			if (i != x && j != y && board[x][y] == board[i][j])
    				return false;
    		}
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }
				};
		SudokuSolver s = new SudokuSolver();
		s.solveSudoku(board);
	}

}
