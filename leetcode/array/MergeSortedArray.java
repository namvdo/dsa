package leetcode.array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstIdx = 0;
        int secondIdx = 0;
        while (firstIdx < m && secondIdx < n) {
            if (nums1[firstIdx] >= nums2[secondIdx]) {
                for (int i = m; i > firstIdx; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[firstIdx] = nums2[secondIdx];
                firstIdx++;
                secondIdx++;
                m = m + 1;
            } else {
                firstIdx++;
            }
        }

        if (n != secondIdx) {
            for (int i = secondIdx; i < n; i++) {
                nums1[firstIdx++] = nums2[i];
            }
        }
    }
}
