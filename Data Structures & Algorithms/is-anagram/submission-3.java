class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> mp = new HashMap<>();
        for(char nm : s.toCharArray()){
            mp.put(nm, mp.getOrDefault(nm, 0)+1);
        }

        for(char nc : t.toCharArray()){
            if(!mp.containsKey(nc)){
                return false;
            }
            mp.put(nc, mp.get(nc)-1);
            if(mp.get(nc) < 0) return false;
        }
        return true;

    }
}
