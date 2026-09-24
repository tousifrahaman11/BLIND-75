class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q1 = new LinkedList<>();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0){
                    q1.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}};

       while(!q1.isEmpty()){
        int[] curr = q1.poll();
        int r = curr[0];
        int c = curr[1];

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            //out of bond
            if(nr < 0 || nr >= n || nc < 0 || nc >= m){
                continue;
            }
            if(grid[nr][nc] != Integer.MAX_VALUE) continue;

            grid[nr][nc] = grid[r][c]+1;
            q1.offer(new int[]{nr, nc});
        }
       }     
    }
}
