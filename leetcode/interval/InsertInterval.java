package leetcode.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] i : intervals) {
            res.add(i);
        }
        res.add(newInterval);
        res.sort(new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        return merge(res);
    }

    int[][] merge(List<int[]> intervals) {
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];
        int i = 0;
        List<int[]> merge = new ArrayList<>();
        while (i < intervals.size()) {
            int nextStart = intervals.get(i)[0];
            int nextEnd = intervals.get(i)[1];
            if (nextStart <= end) {
                end = Math.max(end, nextEnd);
            } else {
                merge.add(new int[] { start, end });
                start = nextStart;
                end = nextEnd;
            }
            i++;
        }
        merge.add(new int[] { start, end });
        return merge.toArray(new int[merge.size()][]);
    }

}
