class Solution {
    private int row, col;

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;

        // Traverse first and last column
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }

            if (board[r][col - 1] == 'O') {
                dfs(board, r, col - 1);
            }
        }

        // Traverse first and last row
        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }

            if (board[row - 1][c] == 'O') {
                dfs(board, row - 1, c);
            }
        }

        // Convert surrounded O -> X
        // Restore safe O's marked as T
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}