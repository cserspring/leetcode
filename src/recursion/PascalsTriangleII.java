package recursion;

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        
        if (rowIndex == 0) {
        	List<Integer> res = new ArrayList<Integer>();
        	res.add(1);
        	return res;
        } else if (rowIndex > 0) {
        	List<Integer> res = getRow(rowIndex - 1);
        	int size = res.size();
        	int tmp = 0;
        	int last = 0;
        	for (int i = 1; i < size; ++i) {
        		tmp = res.get(i);
        		res.set(i, res.get(i) + last);
        		last = tmp;
        	}
        	res.add(1);
        	return res;
        } else {
        	return new ArrayList<Integer>();
        }
    }

}
