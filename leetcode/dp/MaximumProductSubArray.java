package leetcode.dp;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
       int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int curMax = 1, curMin = 1;
        for(int i = 0; i < nums.length; i++) {
            int tmp = nums[i] * curMax;
            curMax = Math.max(Math.max(nums[i] * curMax, nums[i] * curMin), nums[i]);
            curMin = Math.min(Math.min(nums[i] * curMin, tmp), nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
