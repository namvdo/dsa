package leetcode.array;

public class LongestSubArray {
    public int longestSubarray(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int count = 0;
        boolean hasLeftZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left[i] = count;
                count = 0;
                hasLeftZero = true;
            } else {
                count++;
            }
        }
        int rc = 0;
        boolean hasRightZero = false;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == 0) {
                right[j] = rc;
                rc = 0;
                hasRightZero = true;
            } else {
                rc++;
            }
        }
        int res = Integer.MIN_VALUE;
        if (!hasLeftZero && !hasRightZero)
            return nums.length - 1;
        for (int k = 0; k < left.length; k++) {
            res = Math.max(res, left[k] + right[k]);
        }
        return res;
    }
}
