package leetcode.interval;

import java.util.Arrays;
import java.util.Comparator;

public class ArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for(int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
 
}
