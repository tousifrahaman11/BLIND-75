class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int pre = 0, suf = 0;
        for(int i = 0; i<nums.length; i++){
            pre = nums[i] * (pre == 0 ? 1 : pre);
            suf = nums[nums.length-1-i] * (suf == 0 ? 1 : suf);

            res = Math.max(res, Math.max(pre, suf));
        }
        return res;

    }
}
