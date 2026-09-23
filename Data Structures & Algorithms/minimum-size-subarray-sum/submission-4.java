class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int minl = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length; i++){
            r += nums[i];
            while(r>=target){
                minl = Math.min(minl, i-l+1);
                r-=nums[l];
                l++;
            }
        }
        return minl == Integer.MAX_VALUE ? 0 : minl;
    }
}