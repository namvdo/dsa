package leetcode.interval;

import java.util.Arrays;
import java.util.Comparator;

public class ArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] prev = points[0];
        int c = 1;
        for(int i = 1; i < points.length; i++) {
            if (points[i][0] > prev[1]) {
                c++;
                prev = new int[] {points[i][0], points[i][1]};
            } else {
                prev[1] = Math.min(prev[1], points[i][1]);
            }
        }
        return c;
    }
}
