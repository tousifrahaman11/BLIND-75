class Solution {
    private static final int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int r = grid.length; int c = grid[0].length;
        int isl = 0;

        for(int i = 0; i<r; i++){
            for(int j =0; j<c;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    isl++;
                }
            }
        }
        return isl;
    }
    static void dfs(char[][] grid, int i, int j){
        if(i<0  || i >= grid.length || j <0 || j>= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        for (int[] dir1 : dir) {
            dfs(grid, i + dir1[0], j + dir1[1]);
        }
    }
}
