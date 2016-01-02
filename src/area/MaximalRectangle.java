package area;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m;
        int n;
        if (matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) return 0;
        int[] H = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; ++i) {
        	H[i] = 0;
        	L[i] = 0;
        	R[i] = n;
        }
        int max = 0;
        for (int i = 0; i < m; ++i) {
        	int left = 0;
        	int right = n;
        	for (int j = 0; j < n; ++j) {
        		if (matrix[i][j] == '1') {
        			++H[j];
        			L[j] = Math.max(L[j], left);
        		} else {
        			left = j + 1;
        			H[j] = 0;
        			L[j] = 0;
        			R[j] = n;
        		}
        	}
        	
        	for (int j = n - 1; j >= 0; --j) {
        		if (matrix[i][j] == '1') {
        			R[j] = Math.min(R[j], right);
        			max = Math.max((R[j] - L[j]) * H[j], max);
        		} else {
        			right = j;
        		}
        	}
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { { '0', '1', '1', '0', '1' },
				{ '1', '1', '0', '1', '0' }, { '0', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1' },
				{ '0', '0', '0', '0', '0' } };
		MaximalRectangle m = new MaximalRectangle();
		System.out.println(m.maximalRectangle(matrix));
	}

}
