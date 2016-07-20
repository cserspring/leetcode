package array;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m;
        int n;
        if (board == null || (m = board.length) == 0 || (n = board[0].length) == 0) return;
        for (int i = 0; i < m; ++i) {
        	DFS(board, i, 0, m, n);
        	DFS(board, i, n - 1, m, n);
        }
        
        for (int i = 1; i < n - 1; ++i) {
        	DFS(board, 0, i, m, n);
        	DFS(board, m-1, i, m, n);
        }
        
        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
        		if (board[i][j] == 'P')
        			board[i][j] = 'O';
        		else if (board[i][j] == 'O')
        			board[i][j] = 'X';
        	}
        }
    }
    
    private void DFS(char[][] board, int i, int j, int m, int n) {
    	if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
    	board[i][j] = 'P';
    	DFS(board, i-1, j, m, n);
    	DFS(board, i+1, j, m, n);
    	DFS(board, i, j-1, m, n);
    	DFS(board, i, j+1, m, n);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}};
		SurroundedRegions s = new SurroundedRegions();
		s.solve(board);
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
