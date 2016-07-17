package stock;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
    	int n;
        if (prices == null || (n = prices.length) == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMin = prices[0];
        int leftProfit = 0;
        for (int i = 0; i < n; ++i) {
        	if (prices[i] < leftMin) {
        		leftMin = prices[i];
        	} else {
        		int profit = prices[i] - leftMin;
        		if (profit > leftProfit)
        			leftProfit = profit;
        	}
        	
        	left[i] = leftProfit;
        }
        
        int rightMax = prices[n-1];
        int rightProfit = 0;
        for (int i = n - 1; i >= 0; --i) {
        	if (prices[i] > rightMax) {
        		rightMax = prices[i];
        	} else {
        		int profit = rightMax - prices[i];
        		if (profit > rightProfit)
        			rightProfit = profit;
        	}
        	
        	right[i] = rightProfit;
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; ++i) {
        	int profit = left[i] + right[i];
        	if (profit > maxProfit)
        		maxProfit = profit;
        }
        
        return maxProfit;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
		int[] prices = {6,13,1,2};
		System.out.println(b.maxProfit(prices));
	}

}
