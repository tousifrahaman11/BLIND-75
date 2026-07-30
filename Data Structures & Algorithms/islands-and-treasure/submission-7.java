class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] dir = { {1, 0},   // Down
            {-1, 0},  // Up
            {0, 1},   // Right
            {0, -1} 
            };

       while(!q.isEmpty()){
        int[] cell = q.poll();
        int r = cell[0];
        int l = cell[1];

        for(int[] d : dir){
            
            int nr = r+d[0];
            int nl = l+d[1];

            if(nr < 0 || nr >= n || nl <0 || nl >= m){
                continue;
            }
            if(grid[nr][nl] != Integer.MAX_VALUE){
                continue;
            }
            grid[nr][nl] = grid[r][l]+1;
            q.add(new int[]{nr, nl});
        }
       }     
    }
}
