class Solution {
    public int maxSubArray(int[] nums) {
        int maxa = nums[0];
        int curs = 0;

        for(int i = 0; i<nums.length; i++)
        {
            if(curs<0){
                curs = 0;
            }
            curs += nums[i];
            maxa = Math.max(maxa, curs);
        }
        return maxa;
    }
}
