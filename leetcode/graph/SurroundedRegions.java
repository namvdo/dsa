package leetcode.graph;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (isInBorder(m, n, i, j)) {
                    dfs(board, i, j);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    boolean isInBorder(int m, int n, int i, int j) {
        return i == 0 || j == 0 || i == m - 1 || j == n - 1;
    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
    }
}
