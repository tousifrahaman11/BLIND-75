class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int l = 0;
        int maxf = 0;
        int maxl = 0;

        for(int r = 0; r<s.length(); r++){
            char ch = s.charAt(r);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            maxf = Math.max(maxf, mp.get(ch));

            while((r-l+1)-maxf > k){
                char lf = s.charAt(l);
                mp.put(lf, mp.get(lf)-1);
                l++;
            }
            maxl = Math.max(maxl, r-l+1);
        }
        return maxl;
    }
}
