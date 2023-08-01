package leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class NumOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> visited = new HashSet<>();
        int numIslands = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                String key = String.format("%d-%d", i, j);
                if (grid[i][j] == '1' && !visited.contains(key)) {
                    bfs(grid, i, j, visited);
                    numIslands += 1;
                }
            }
        }
        return numIslands;
    }


    void bfs(char[][] grid, int i, int j, Set<String> visited) {
        LinkedList<String> queue = new LinkedList<>();
        String key = String.format("%d-%d", i, j);
        queue.add(key);
        visited.add(key);
        int[][] directions = new int[][] {
            new int[] {-1, 0},
            new int[] {0, -1},
            new int[] {1, 0},
            new int[] {0, 1}
        };
        while (!queue.isEmpty()) {
            String[] pos = queue.removeFirst().split("-");
            for(int[] dir : directions) {
                int r = Integer.parseInt(pos[0]) + dir[0];
                int c = Integer.parseInt(pos[1]) + dir[1];
                String p = String.format("%d-%d", r, c);
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length 
                    && !visited.contains(p) && grid[r][c] == '1'
                ) {
                    visited.add(p);
                    queue.add(p);
                }
            }
        }
    }
}
