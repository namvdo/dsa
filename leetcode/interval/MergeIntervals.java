package leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 0;
        while (i < intervals.length) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (nextStart <= end) {
                end = Math.max(end, nextEnd);
            } else {
                ans.add(new int[] { start, end });
                start = nextStart;
                end = nextEnd;
            }
            i++;
        }
        ans.add(new int[] { start, end });
        return ans.toArray(new int[ans.size()][]);
    }

}
