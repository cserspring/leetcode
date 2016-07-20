package array;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	class Point{
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
    public void solve(char[][] board) {
        int m;
        int n;
        if (board == null || (m = board.length) == 0 || (n = board[0].length) == 0) return;
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < m; ++i) {
        	queue.add(new Point(i, 0));
        	queue.add(new Point(i, n-1));
        }
        
        for (int i = 1; i < n - 1; ++i) {
        	queue.add(new Point(0, i));
        	queue.add(new Point(m-1, i));
        }
        
        while (!queue.isEmpty()) {
        	Point p = queue.poll();
        	check(board, p.x, p.y, m, n, queue);
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
    
    private void check(char[][] board, int i, int j, int m, int n, Queue<Point> queue) {
    	if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
    	board[i][j] = 'P';
    	queue.add(new Point(i-1, j));
    	queue.add(new Point(i+1, j));
    	queue.add(new Point(i, j-1));
    	queue.add(new Point(i, j+1));
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
