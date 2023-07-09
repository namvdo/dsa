package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        int f = 0, s = 0;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (f < nums1.length && s < nums2.length) {
            if (nums1[f] == nums2[s]) {
                if (res.isEmpty()) {
                    res.add(nums1[f]);
                } else if (!res.isEmpty() && res.get(res.size() - 1) != nums1[f]) {
                    res.add(nums1[f]);
                }
                f++;
                s++;
            } else if (nums1[f] > nums2[s]) {
                s++;
            } else {
                f++;
            }
        }
        return res.stream().mapToInt(e -> e).toArray();
    }
}
