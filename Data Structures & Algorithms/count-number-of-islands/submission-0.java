class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int cn = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    cn++;
                }
            }
        }
        return cn;
    }
    static void dfs(char[][] grid, int l, int r){
        if(l < 0 || r < 0 || l >= grid.length || r >= grid[0].length){
            return;
        }

        if(grid[l][r] == '0'){
            return;
        }
        grid[l][r] = '0';
        dfs(grid,l-1, r);
        dfs(grid, l+1, r);
        dfs(grid, l, r-1);
        dfs(grid, l, r+1);
    }
}
