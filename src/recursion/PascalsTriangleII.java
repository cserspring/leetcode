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
        	for (int i = res.size() - 1; i > 0; --i) 
        		res.set(i, res.get(i) + res.get(i - 1));        	
        	res.add(1);
        } 
        
        return res;
    }

}
