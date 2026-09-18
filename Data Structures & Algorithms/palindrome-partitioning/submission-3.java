class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> li = new ArrayList<>();
        solve(0 , s, new ArrayList<>(), li);
        return li;
    }
    void solve(int idx, String s, List<String> cur, List<List<String>> li){
        if(idx == s.length()){
            li.add(new ArrayList<>(cur));
            return;
        }
        for(int i = idx ; i<s.length(); i++){
            String sb = s.substring(idx, i+1);
            if(isP(sb)){
                cur.add(sb);
                solve(i+1, s, cur, li);
                cur.remove(cur.size()-1);
            }
        }
    }
    boolean isP(String str){
        int lf = 0, rg = str.length()-1;

        while(lf<rg){
            if(str.charAt(lf) != str.charAt(rg)){
                return false;
            }
            lf++;
            rg--;
        }
        return true;
    }
}
