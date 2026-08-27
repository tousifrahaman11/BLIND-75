class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1) return false;

        List<List<Integer>> li = new ArrayList<>();

        for(int i = 0; i< n; i++){
            li.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            li.get(edge[0]).add(edge[1]);
            li.get(edge[1]).add(edge[0]);
        }
        Set<Integer> st = new HashSet<>();

        if(!dfs(0, -1, st, li)){
            return false;
        }
        return st.size() == n;
    }
    private boolean dfs(int node, int parent, Set<Integer> st, List<List<Integer>> li){
        if(st.contains(node)){
            return false;
        }
        st.add(node);
        for(int nei : li.get(node)){
            if(nei == parent){
                continue;
            }
            if(!dfs(nei, node, st, li)){
                return false;
            }
        }
        return true;
    }
}
