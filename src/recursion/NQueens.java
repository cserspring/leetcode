package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
    	char[][] board = new char[n][n];
    	for (int i = 0; i < n; ++i) {
    		for (int j = 0; j < n; ++j) {
    			board[i][j] = '.';
    		}
    	}
    	List<List<String>> res = new ArrayList<List<String>>();
    	solve(res, 0, board, n);
    	return res;
    }
    
    private void solve(List<List<String>> res, int row, char[][] board, int n) {
    	if (row >= n) {
    		List<String> record = new ArrayList<String>();
    		for (int i = 0; i < n; ++i) {
    			StringBuilder sb = new StringBuilder();
    			for (int j = 0; j < n; ++j) {
    				if (board[i][j] != 'Q')
    					board[i][j] = '.';
    				sb.append(board[i][j]);
    			}
    			record.add(sb.toString());
    		}    		
    		
    		res.add(record);
    		return;
    	}
    	
    	for (int i = 0; i < n; ++i) {
    		if (board[row][i] == '.') {
            	char[][] cpyBoard = copyBoard(board, n);
    			setForbiddenArea(cpyBoard, row, i, n);
    			solve(res, row + 1, cpyBoard, n);
    		}
    	}
    }
    
    private void setForbiddenArea(char[][] board, int i, int j, int n) {
    	// Rows and columns
    	for (int k = 0; k < n; ++k) {
    		board[i][k] = 'F';
    		board[k][j] = 'F';
    	}
    	// Diagonal
    	for (int k = 1 - n; k <= n - 1; ++k) {
   			if (i + k >= 0 && i + k < n && j + k >= 0 && j + k < n)
   				board[i + k][j + k] = 'F';
   			if (i + k >= 0 && i + k < n && j - k >= 0 && j - k < n)
   				board[i + k][j - k] = 'F';
    	}
    	board[i][j] = 'Q';
    }
    
    private char[][] copyBoard(char[][] board, int n) {
    	char[][] cpyBoard = new char[n][n];
    	for (int i = 0; i < n; ++i) {
    		for (int j = 0; j < n; ++j)
    			cpyBoard[i][j] = board[i][j];
    	}
    	return cpyBoard;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens n = new NQueens();
		List<List<String>> res = n.solveNQueens(4);
		for (List<String> subRes : res) {
			for (String s : subRes)
				System.out.print(s + "\t");
			System.out.println("\n");
		}
	}

}
