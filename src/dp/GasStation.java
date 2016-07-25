package dp;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int n;
        if (gas == null || (n = gas.length) == 0) return 0;
        int index = -1;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i)
        	dp[i] = gas[i] - cost[i];
        int oil = 0;
        int total = 0;
        for (int i = 0; i < n; ++i) {
        	oil += dp[i];
        	total += dp[i];
        	if (oil < 0) {
        		index = i;
        		oil = 0;
        	}
        }
        
        if (total < 0) return -1;
        return index + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
