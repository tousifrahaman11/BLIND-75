class Solution {
    public int findMin(int[] nums) {
        
        int l = 0, r = nums.length-1;

        while(l<r){
            int md = l+(r-l)/2;
            if(nums[md] < nums[r]){
                r = md;
            } else{
                l = md+1;
            }
        }
        return nums[l];
    }
}
