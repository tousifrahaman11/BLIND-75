class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> li = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        split(0, s, l1, li);
        return li;
    }
    void split(int i, String s, List<String> l1, List<List<String>> li){
        if(i >= s.length()){
            li.add(new ArrayList<>(l1));
            return;
        }
        for(int j = i; j<s.length(); j++){
            if(isPal(s, i, j)){
                l1.add(s.substring(i, j+1));
                split(j+1, s, l1, li);
                l1.remove(l1.size()-1);
            }
        }
    }
    boolean isPal(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
