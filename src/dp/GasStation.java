package dp;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int n;
        if (gas == null || (n = gas.length) == 0) return 0;
        int index = -1;
        for (int i = 0; i < n; ++i) {
            int oil = 0;
            int j;
        	for (j = i; j < n + i; ++j) {
        		if (oil + gas[j%n] < cost[j%n]) {
        			break;
        		} else {
        			oil = oil + gas[j%n] - cost[j%n];
        		}
        	}
        	
        	if ( j == n + i) {
        		index = i;
        		break;
        	}
        }
        
        return index;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
