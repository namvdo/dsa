package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int len = 0;
                while (set.contains(nums[i] + len)) {
                    len++;
                    longest = Math.max(longest, len);
                }
            }
        }
        return longest;
    }
}
