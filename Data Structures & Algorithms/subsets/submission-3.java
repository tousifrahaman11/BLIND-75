class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        backt(0 , nums, li, new ArrayList<>());
        return li;
    }
    void backt(int st, int[] nums, List<List<Integer>> li, List<Integer> cur){
        if(st == nums.length){
            li.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[st]);
        backt(st+1, nums, li, cur);
        cur.remove(cur.size()-1);
        backt(st+1, nums, li, cur);
    }
}
