package recursion;

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res;
        if (rowIndex == 0) {
        	res = new ArrayList<Integer>();
        	res.add(1);
        } else {
        	res = getRow(rowIndex - 1);
        	int tmp = 0;
        	int last = 1;
        	for (int i = 1; i < res.size(); ++i) {
        		tmp = res.get(i);
        		res.set(i, res.get(i) + last);
        		last = tmp;
        	}
        	res.add(1);
        } 
        
        return res;
    }

}
