class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1){
            return false;
        }
        List<List<Integer>> li = new ArrayList<>();
        for(int i = 0; i<n;i++){
            li.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            li.get(edge[0]).add(edge[1]);
            li.get(edge[1]).add(edge[0]);
        }
        Set<Integer> st = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,-1});
        st.add(0);

        while(!q.isEmpty()){
            int pair[] = q.poll();
            int node = pair[0], parent = pair[1];
            for(int nei : li.get(node)){
                if(nei == parent){
                    continue;
                }
                if(st.contains(nei)){
                    return false;
                }
                st.add(nei);
                q.offer(new int[]{nei, node});
            }
        }
        return st.size() == n;
    }
}
