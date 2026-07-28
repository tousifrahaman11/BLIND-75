class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int maxm = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxm = Math.max(maxm, dfs(grid, i, j));
                }
            }
        }
        return maxm;
    }
    static int dfs(int[][] grid, int l, int r){
        if(l<0 || r<0 || l>=grid.length || r >= grid[0].length){
            return 0;
        }
        if(grid[l][r] == 0) return 0;

        grid[l][r]= 0;
        return 1 + dfs(grid,l-1, r) + dfs(grid, l+1, r)+
        dfs(grid, l, r-1) +
        dfs(grid, l, r+1);

    }
}
