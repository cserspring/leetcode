package recursion;

public class NumberOfIslands {
    
	public int numIslands(char[][] grid) {
        int count  = 0;
		int m = grid.length;
		int n = 0; 
		if (m > 0)
			n = grid[0].length;
        
        for (int i = 0; i < m; ++i) {
        	for (int j = 0; j < n; ++j) {
        		if (grid[i][j] == '1') {
        			visit(grid, i, j, m, n);
        			++count;
        		}
        	}
        }
        
        return count;
    }
    
	// DFS !!!
	public void visit(char[][] grid, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n)
			return;
		if (grid[i][j] == '1') {
			grid[i][j] = '2';
			visit(grid, i - 1, j, m, n);
			visit(grid, i + 1, j, m, n);
			visit(grid, i, j - 1, m, n);
			visit(grid, i, j + 1, m, n);
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
