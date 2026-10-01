class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suff = new int[n+1];

        for(int i = n-1; i>=0; i--){
            suff[i] += suff[i+1] +piles[i];
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1; i>=0; i--){
            for(int j = 1; j<=n; j++){
                if(i+2 * j >= n){
                    dp[i][j] = suff[i];
                    continue;
                }
                for(int x = 1; x <= 2*j && i+x<=n; x++){
                    dp[i][j] = Math.max(dp[i][j], suff[i]-dp[i+x][Math.max(j, x)]);
                }
            }
        }
        return dp[0][1];
    }
}