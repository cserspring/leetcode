package recursion;

public class NumberOfIslands {
    
	public int numIslands(char[][] grid) {
        int count  = 0;
		int m = grid.length;
		int n = 0; 
		if (m > 0)
			n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
        		visited[i][j] = false;
        	}
        }
        
        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
        		if (!visited[i][j] && grid[i][j] == '1') {
        			visit(grid, i, j, m, n, visited);
        			++count;
        		}
        	}
        }
        
        return count;
    }
    
	public void visit(char[][] grid, int i, int j, int m, int n, boolean[][] visited) {
		visited[i][j] = true;
		if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
			visit(grid, i - 1, j, m, n, visited);
		} 
		
		if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
			visit(grid, i, j - 1, m, n, visited);
		}

		if (j + 1 < n && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
			visit(grid, i, j + 1, m, n, visited);
		} 

		if (i + 1 < m && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
			visit(grid, i + 1, j, m, n, visited);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfIslands obj = new NumberOfIslands();
		char[][] grid0 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		char[][] grid1 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		
		System.out.println(obj.numIslands(grid0));
		System.out.println(obj.numIslands(grid1));
	}

}
