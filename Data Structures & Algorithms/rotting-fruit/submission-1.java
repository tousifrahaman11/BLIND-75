class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<int[]> q1 = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    q1.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int mins = 0;
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!q1.isEmpty() && fresh > 0){
            int size = q1.size();

            for(int i = 0; i<size; i++){
                int[] curr = q1.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                     if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    // Only fresh fruits can become rotten
                    if (grid[nr][nc] != 1) {
                        continue;
                    }

                    //make it rotten

                    grid[nr][nc] = 2;
                    fresh--;

                    q1.offer(new int[]{nr, nc});
                }
            }
            mins++;
        }
        return fresh == 0 ? mins : -1;
    }
}
