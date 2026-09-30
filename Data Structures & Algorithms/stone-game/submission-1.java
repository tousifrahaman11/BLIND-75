class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for(int i = n-1; i>=0; i--){
            for(int j = i; j<n; j++){
                boolean ev = (j-i) %2 == 0;
                int left = ev ? piles[i] : 0;
                int right = ev ? piles[j] : 0;
                if(i == j){
                    dp[i][j] = left;
                } else{
                    dp[i][j] = Math.max(dp[i+1][j] + left, dp[i][j-1] + right);
                }
            }
        }
        int total = 0;
        for(int pile : piles){
            total += pile;
        }
        int alic = dp[0][n-1];
        return alic > total - alic;
    }
}