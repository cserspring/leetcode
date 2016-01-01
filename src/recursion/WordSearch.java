package recursion;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m;
        int n;
        int wordLen;
        if (board == null || word == null || 
        		(m = board.length) == 0 || (n = board[0].length) == 0 || 
        		(wordLen = word.length()) == 0 || wordLen > m * n) 
        	return false;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
                if (dfs(board, i, j, visited, word, 0, m, n, wordLen))
                	return true;
        	}
        }
        return false;
    }
 
    private boolean dfs(char[][] board, int x, int y, boolean[][] visited, String word, int pos, int m, int n, int wordLen) {
    	if (visited[x][y] || board[x][y] != word.charAt(pos)) return false;
    	if (pos == wordLen - 1) return true;
    	visited[x][y] = true;

    	if (x - 1 >= 0 && dfs(board, x - 1, y, visited, word, pos + 1, m, n, wordLen)) return true;
    	
    	if (x + 1 < m && dfs(board, x + 1, y, visited, word, pos + 1, m, n, wordLen)) return true;
    	
    	if (y - 1 >= 0 && dfs(board, x, y - 1, visited, word, pos + 1, m, n, wordLen)) return true;
    	
    	if (y + 1 < n && dfs(board, x, y + 1, visited, word, pos + 1, m, n, wordLen)) return true;
    	
    	visited[x][y] = false;
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = 
						{
							{'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}
						};
		WordSearch w = new WordSearch();
		System.out.println(w.exist(board, "ABCCED"));
		System.out.println(w.exist(board, "SEE"));
		System.out.println(w.exist(board, "ABCB"));
	}

}
