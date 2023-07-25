package leetcode.array;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] tmp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = count(i, j, board);
                if (board[i][j] == 1 && live < 2) {
                    tmp[i][j] = 0;
                } else if (board[i][j] == 1 && (live == 2 || live == 3)) {
                    tmp[i][j] = 1;
                } else if (board[i][j] == 1 && (live > 3)) {
                    tmp[i][j] = 0;
                } else if (board[i][j] == 0 && (live == 3)) {
                    tmp[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            board[i] = tmp[i].clone();
        }
    }

    private int count(int i, int j, int[][] board) {
        int[][] direction = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { -1, 0 } };
        int count = 0;
        for (int[] dir : direction) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                count += board[x][y];
            }
        }
        return count;
    }

}
