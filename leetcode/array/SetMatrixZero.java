package leetcode.array;

import java.util.Arrays;

public class SetMatrixZero {
    public void setZero(int[][] matrix) {
        int[] markRow = new int[matrix.length];
        int[] markCol = new int[matrix[0].length];
        Arrays.fill(markRow, 1);
        Arrays.fill(markCol, 1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    markRow[i] = 0;
                    markCol[j] = 0;
                }
            } 
        }
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (markRow[i] == 0 || markCol[j] == 0) {
                    matrix[i][j] = 0;
                }
            }   
        }
    } 
}
