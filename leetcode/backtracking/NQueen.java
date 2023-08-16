package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiags = new HashSet<>();
    Set<Integer> negDiags = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, n);
        return res;
    }

    void dfs(List<List<String>> res, List<String> list, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiags.contains(row + c) || negDiags.contains(row - c)) {
                continue;
            }
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[c] = 'Q';
            String rowStr = new String(chars);
            list.add(rowStr);
            cols.add(c);
            posDiags.add(row + c);
            negDiags.add(row - c);
            dfs(res, list, row + 1, n);
            list.remove(list.size() - 1);
            cols.remove(c);
            posDiags.remove(row + c);
            negDiags.remove(row - c);
        }
    }
}
