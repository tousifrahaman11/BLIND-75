class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> mp1 = new HashMap<>();

        for(char ch : s1.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        int l = 0;
        for(int r = 0; r<s2.length(); r++){
            char ch = s2.charAt(r);
            mp1.put(ch, mp1.getOrDefault(ch, 0)+1);

            while(r-l+1 > s1.length()){
                char lfc = s2.charAt(l);
                mp1.put(lfc, mp1.get(lfc)-1);
            
            if(mp1.get(lfc) == 0){
                mp1.remove(lfc);
            }
            l++;
            }
             if(mp1.equals(mp)) return true;
        }
       

        return false;
    }
}
