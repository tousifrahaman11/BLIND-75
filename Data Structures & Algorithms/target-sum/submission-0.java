class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int tots = 0;

        for(int num : nums){
            tots += num;
        }

        if(Math.abs(target) > tots){
            return 0;
        }

        if((tots + target) % 2 != 0){
            return 0;
        }
        int subs = (tots + target)/2;
        int[] dp = new int[subs+1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = subs; j>=num; j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[subs];
    }
}
