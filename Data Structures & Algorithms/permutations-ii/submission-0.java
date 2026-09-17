class Solution {
     List<List<Integer>> li;
    public List<List<Integer>> permuteUnique(int[] nums) {
       li = new ArrayList<>();
       Arrays.sort(nums);
        solve(0, nums);
        return li;
    }
    void solve(int i , int[] nums){
        if(i == nums.length){
            List<Integer> tmp = new ArrayList<>();
            for(int num : nums) tmp.add(num);
            li.add(tmp);
            return;
        }
        for(int j = i; j<nums.length; j++){
            if(j > i && nums[j] == nums[i]) continue;

            swap(nums, i, j);
            solve(i+1, nums);
        }
        for(int j = nums.length-1; j>i; j--){
            swap(nums, i, j);
        }
    }
    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}