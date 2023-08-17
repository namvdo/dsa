package leetcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int x : nums1) {
            queue.offer(new int[] { x + nums2[0], 0 });
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            int sum = pair[0];
            int pos = pair[1];

            List<Integer> curPair = new ArrayList<>();
            curPair.add(sum - nums2[pos]);
            curPair.add(nums2[pos]);
            res.add(curPair);
            if (pos + 1 < nums2.length) {
                queue.offer(new int[] { sum - nums2[pos] + nums2[pos + 1], pos + 1 });
            }
            k--;
        }
        return res;
    }
}
