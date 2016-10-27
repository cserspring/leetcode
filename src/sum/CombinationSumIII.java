package sum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	private List<List<Integer>> res;
	private int size = 9;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        res = new ArrayList<List<Integer>>();
        List<Integer> subRes = new ArrayList<Integer>();
        dfs(k, n, 0, subRes, A);
        return res;
    }
    
    private void dfs(int k, int sum, int index, List<Integer> subRes, int[] A) {
    	if (sum < 0) return;
    	if (subRes.size() == k && sum == 0) {
    		res.add(new ArrayList<Integer>(subRes));
    		return;
    	}
    	
    	for (int i = index; i < size; ++i) {
    		subRes.add(A[i]);
    		dfs(k, sum - A[i], i + 1, subRes, A);
    		subRes.remove(subRes.size() - 1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII c = new CombinationSumIII();
		List<List<Integer>> res = c.combinationSum3(2, 18);
		for (List<Integer> subRes : res) {
			for (int i : subRes) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
