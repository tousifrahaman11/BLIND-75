class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i = n-1; i>=0; i--){
            for(int buy = 1; buy >= 0; buy--){
                if(buy == 1){
                    int b1 = dp[i+1][0]-prices[i];
                    int cold = dp[i+1][1];
                    dp[i][1] = Math.max(b1, cold); 
                } else{
                    int sell = (i+2<n) ? dp[i+2][1]+prices[i] : prices[i];
                    int cold = dp[i+1][0];
                    dp[i][0] = Math.max(sell, cold);
                }
            }
        }
        return dp[0][1];
    }
}
