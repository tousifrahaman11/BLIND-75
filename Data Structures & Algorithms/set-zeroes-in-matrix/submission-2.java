class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rwz = new boolean[row];
        boolean[] coz = new boolean[col];

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col ; j++){
                if(matrix[i][j] == 0){
                    rwz[i] = true;
                    coz[j] = true;
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j<col; j++){
                if(rwz[i] || coz[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
