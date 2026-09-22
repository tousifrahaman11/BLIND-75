class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sm = 0 , rm = 0;
        for(int nm : nums){
            mp.put(nm, mp.getOrDefault(nm, 0)+1);

            if(mp.get(nm) > rm){
                sm = nm;
                rm = mp.get(nm);
            }
        }
        return sm;
    }
}