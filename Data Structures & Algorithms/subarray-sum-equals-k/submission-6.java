class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer, Integer> mp = new HashMap<>();
       int l = 0;
       int count  = 0;
       mp.put(0,1);

       for(int r = 0; r<nums.length; r++){
         l+=nums[r];
         if(mp.containsKey(l-k)){
            count += mp.get(l-k);
         }
         mp.put(l, mp.getOrDefault(l, 0)+1);
       } 
       return count;
    }
}