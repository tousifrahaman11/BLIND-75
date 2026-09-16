class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        solve(nums, li, 0);
        return li;
    }
    static void solve(int[] nums, List<List<Integer>> li, int st){
        if(st == nums.length){
            List<Integer> l1 = new ArrayList<>();
            for(int nm : nums) l1.add(nm);
            li.add(l1);
            return;
        }
        for(int i = st; i<nums.length; i++){
            swap(nums, i, st);
            solve(nums ,li, st+1);
            swap(nums, i,st);
        }
    }
    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
