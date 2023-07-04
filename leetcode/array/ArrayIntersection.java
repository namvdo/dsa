package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int f = 0;
        int s = 0;
        List<Integer> rs = new ArrayList<>();
        while (f < nums1.length && s < nums2.length) {
            if (nums1[f] == nums2[s]) {
                rs.add(nums1[f]);
                f++;
                s++;
            } else if (nums1[f] > nums2[s]) {
                s++;
            } else {
                f++;
            }
        }
        return rs.stream().mapToInt(e -> e).toArray();
    }
}
