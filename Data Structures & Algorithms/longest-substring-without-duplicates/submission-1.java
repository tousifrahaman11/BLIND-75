class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int maxl = 0;
        int l = 0;
        for(int r = 0; r<s.length(); r++){
            while(st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }
            st.add(s.charAt(r));
            maxl = Math.max(maxl, r-l+1);
        }
        return maxl;
    }
}
