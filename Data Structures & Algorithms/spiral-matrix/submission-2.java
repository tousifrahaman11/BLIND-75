class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        int[][] dir = {{0,1},{1,0}, {0,-1}, {-1,0}};
        int[] step = {matrix[0].length, matrix.length-1};

        int r = 0, c = -1, d = 0;

        while(step[d%2]>0){
            for(int i = 0; i<step[d%2]; i++){
                r+=dir[d][0];
                c+=dir[d][1];
                li.add(matrix[r][c]);
            }
            step[d%2]--;
            d = (d+1)%4;
        }
        return li;
    }
}
