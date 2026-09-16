class Solution {
    List<List<Integer>> li;
    public List<List<Integer>> combine(int n, int k) {
         li = new ArrayList<>();
        backt(1,n, k, new ArrayList<>());
        return li;
    }
    void backt(int i, int n, int k, List<Integer> cur){
        if(cur.size() == k){
            li.add(new ArrayList<>(cur));
            return;
        }
        for(int d = i; d<=n; d++){
            cur.add(d);
            backt(d+1, n, k, cur);
            cur.remove(cur.size()-1);
        }
    }
}