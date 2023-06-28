package leetcode.array;
import java.util.*;

public class ValidSudoku {
     public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<String, Set<Integer>> squares = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if ('.' == c) continue;
                int k = i / 3; 
                int z = j / 3;
                String key = String.format("%d%d", k, z);
                if (rows.get(i) == null)  {
                    rows.put(i, new HashSet<>());
                }
                if (cols.get(j) == null) {
                    cols.put(j, new HashSet<>());
                }
                if (squares.get(key) == null) {
                    squares.put(key, new HashSet<>());
                }
                int num = Integer.parseInt(c + "");
                Set<Integer> curRowVals = rows.get(i);
                if (curRowVals.contains(num)) return false;
                Set<Integer> curColVals = cols.get(j);
                if (curColVals.contains(num)) return false;
                Set<Integer> curSquareVals = squares.get(key);
                if (curSquareVals.contains(num)) return false;
                curRowVals.add(num);
                curColVals.add(num);
                curSquareVals.add(num);
                rows.put(i, curRowVals);
                cols.put(j, curColVals);
                squares.put(key, curSquareVals);
            }
        }
        return true;
    }
}
