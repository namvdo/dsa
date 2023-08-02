package leetcode.array;

import java.util.Arrays;

public class KSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1, opts = 0;
        while (low < high) {
            if (nums[low] + nums[high] == k) {
                low++;
                high--;
                opts++;
            } else if (nums[low] + nums[high] > k)
                high--;
            else
                low++;
        }
        return opts;
    }
}
