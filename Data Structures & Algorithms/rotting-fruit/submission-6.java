class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fr = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});    
                } else if(grid[i][j] == 1){
                    fr++;
                }
            }
        }
        if(fr == 0) return 0;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int min = 0; 

        while(!q.isEmpty() && fr > 0){
            int sz = q.size();
            
            for(int i = 0; i <sz; i++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int[] dr : dir){
                    int lx = x+dr[0];
                    int ly = y + dr[1];

                    if(lx < n && lx >= 0 && ly >= 0 && ly < m && grid[lx][ly] == 1){
                        grid[lx][ly] = 2;
                        fr--;
                        q.offer(new int[]{lx, ly});
                    }
                }
            }
            min++;
        }
        return fr == 0 ? min : -1;
    }
}
