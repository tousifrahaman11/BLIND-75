class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int stonS = 0;
        for(int stone : stones){
            stonS += stone;
        } 
        int target = (stonS +1)/2;
        dp = new int[stones.length][target+1];
        for(int i = 0; i<stones.length; i++){
            for(int j = 0; j<=target; j++){
                dp[i][j] = -1;
            }
        }
        return dfs(0,0, stones, stonS, target);
    }
    private int dfs(int i, int total, int[] stones, int stonS, int target){
        if(total >= target || i == stones.length){
            return Math.abs(total - (stonS - total));
        }
        if(dp[i][total] != -1){
            return dp[i][total];
        }
        dp[i][total] = Math.min(dfs(i+1, total, stones, stonS, target), dfs(i+1, total + stones[i], stones, stonS,target));

        return dp[i][total];
    }
}