class Solution {
    private int[][] dp;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        dp = new int[nums.length][2];
        for(int i = 0; i<nums.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return Math.max(solve(0,1, nums), solve(1, 0, nums));
    }
    int solve(int i, int flags, int[] nums){
        if(i >= nums.length || flags == 1 && i == nums.length-1){
            return 0;
        }
        if(dp[i][flags] != -1){
            return dp[i][flags];
        }
        int tk = nums[i] + solve( i+2, flags, nums);
        int ntk = solve( i+1 ,flags, nums);

        return dp[i][flags] = Math.max(tk, ntk);
    }
}
