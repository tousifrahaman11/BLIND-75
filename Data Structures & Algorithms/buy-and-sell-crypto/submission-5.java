class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int l = 0;

        for(int r = 1; r<prices.length; r++){
            if(prices[r] < prices[l]) {
                l=r;
            }
            int count  = prices[r] - prices[l];
            maxp = Math.max(maxp, count);
           
        }
        return maxp;
    }
}
