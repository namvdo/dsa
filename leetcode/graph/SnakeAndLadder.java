package leetcode.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadder {
    public int snakesAndLadders(int[][] board) {
        int len = board.length;
        Collections.reverse(Arrays.asList(board));
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {1, 0});
        while (!queue.isEmpty()) {
            int[] squareMove = queue.poll();
            int square = squareMove[0];
            int move = squareMove[1];
            for(int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                int[] rowCol = boardPosition(len, nextSquare);
                int row = rowCol[0];
                int col = rowCol[1];
                if (board[row][col] != -1) {
                    nextSquare = board[row][col];
                }
                if (nextSquare == len * len) {
                    return move + 1;
                }
                if (!visited.contains(nextSquare)) {
                    queue.add(new int[] {nextSquare, move + 1});
                    visited.add(nextSquare);
                }
            }
        }
        return -1;
    }

    int[] boardPosition(int n, int square) {
        int r = (square - 1) / n;
        int c = (square - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[] {r, c};
    }
}
