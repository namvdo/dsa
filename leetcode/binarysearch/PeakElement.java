package leetcode.binarysearch;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int n = nums.length;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        int start = 1;
        int end = n - 2;
        while (start <= end) {
            int m = start + (end - start) / 2;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1])
                return m;
            else if (nums[m] < nums[m - 1]) {
                end = m - 1;
            } else if (nums[m] < nums[m + 1]) {
                start = m + 1;
            }
        }
        return -1;
    }
}
