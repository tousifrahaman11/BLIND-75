class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<>();
        backt(nums, target, li, 0);
        return res;
    }
    void backt(int[] nums, int target, List<Integer> li, int i){
        if(target == 0){
            res.add(new ArrayList(li));
            return;
        }
        if(target <0 || i >= nums.length){
            return;
        }
        li.add(nums[i]);
        backt(nums, target - nums[i], li, i);
        li.remove(li.size()-1);
        backt(nums, target, li, i+1);
    }
}
