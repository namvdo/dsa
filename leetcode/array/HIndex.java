package leetcode.array;

import java.util.Arrays;

public class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations.length == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        int hIdx = 0;
        for (int i = 0; i < citations.length; i++) {
            int curIdx = i + 1;
            int c = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= curIdx) {
                    c++;
                }
            }
            if (c >= curIdx) {
                hIdx = curIdx;
            }
        }
        return hIdx;
    }
    
}
