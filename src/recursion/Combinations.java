package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> record = new ArrayList<Integer>();
    	generateRecord(res, record, 1, n, k);
    	return res;
    }
    
    private void generateRecord(List<List<Integer>> res, List<Integer> record, int start, int end, int k) {
    	if (k == 0) {
    		res.add(record);
    		return;
    	}
    	
    	for (int i = start; i <= end - k + 1; ++i) { 
    		List<Integer> newRecord = new ArrayList<Integer>(record);
    		newRecord.add(i);
    		generateRecord(res, newRecord, i + 1, end, k - 1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c = new Combinations();
		List<List<Integer>> res = c.combine(4, 2);
		for (List<Integer> l : res) {
			for (int i : l) 
				System.out.print(i + "\t");
			System.out.println();
		}
	}

}
