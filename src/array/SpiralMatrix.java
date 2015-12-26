package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList<Integer>();
    	int m = 0;
    	int n  =0;
    	if (matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) return res;
    	int diagonal = (m - m / 2) < (n - n / 2) ? (m - m / 2) : (n - n / 2);
    	for (int i = 0; i < diagonal; ++i) {
    		scan(res, matrix, i, m, n);
    	}
    	
    	return res;
    }
    
    private void scan(List<Integer> res, int[][] matrix, int i, int m, int n) {
    	for (int x = i; x < n - i; ++x) {
    		res.add(matrix[i][x]);
    	}
    	
    	for (int x = i + 1; x < m - i; ++x) {
    		res.add(matrix[x][n - i - 1]);
    	}
    	
    	if (i != m - i - 1) {
    		for (int x = n - i - 2; x >= i; --x) {
    			res.add(matrix[m - i - 1][x]);
    		}
    	}
    	
    	if (i != n - i - 1) {
    		for (int x = m - i - 2; x > i; --x) {
    			res.add(matrix[x][i]);
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] matrix = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
		int[][] matrix = {{ 1,2,3,4,5,6,7,8,9,10 }};
		for(int i : (new SpiralMatrix()).spiralOrder(matrix)){
			System.out.println(i);
		}
	}

}
