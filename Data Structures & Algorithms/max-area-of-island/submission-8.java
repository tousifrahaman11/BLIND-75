class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];
        int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}};
        int maxa = 0;

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    Queue<int[]> q1 = new LinkedList<>();
                    q1.offer(new int[]{i, j});
                    vis[i][j] = true;
                    int perim = 0;
                    while(!q1.isEmpty()){
                        int[] cell = q1.poll();
                        int x = cell[0], y = cell[1];
                        perim++;
                        for(int[] dir : direc){
                            int nx = x + dir[0];
                            int ny = y + dir[1];

                            if(nx>=0 && ny>=0 && nx < row && ny < col && grid[nx][ny] == 1 && !vis[nx][ny]){
                                vis[nx][ny] = true;
                                q1.offer(new int[]{nx, ny});
                            }  
                        }
                    }
                    maxa = Math.max(maxa, perim);
                }
            }
        } 
        return maxa;
    }
}
