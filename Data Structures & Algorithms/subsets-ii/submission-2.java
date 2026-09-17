class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, nums, li, new ArrayList<>());
        return li;
    }
    void solve(int idx, int[] nums, List<List<Integer>> li, List<Integer> cur){
           li.add(new ArrayList<>(cur));
         
        for(int i = idx; i<nums.length; i++){
            if(i >idx && nums[i] == nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            solve(i+1, nums, li, cur);
            cur.remove(cur.size()-1);
        }
    }
}
