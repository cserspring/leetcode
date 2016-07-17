package stock;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
    	int n;
        if (prices == null || (n = prices.length) == 0) return 0;
        int[] left = new int[n];
        int leftMin = prices[0];
        int leftProfit = 0;
        for (int i = 0; i < n; ++i) {
        	leftMin = Math.min(leftMin, prices[i]);
        	leftProfit = Math.max(leftProfit, prices[i] - leftMin);        	
        	left[i] = leftProfit;
        }
        
        int maxProfit = 0;
        
        int rightMax = prices[n-1];
        int rightProfit = 0;
        for (int i = n - 1; i >= 0; --i) {
        	rightMax = Math.max(rightMax, prices[i]);
        	rightProfit = Math.max(rightProfit, rightMax - prices[i]);
        	maxProfit = Math.max(maxProfit, left[i] + rightProfit);
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
