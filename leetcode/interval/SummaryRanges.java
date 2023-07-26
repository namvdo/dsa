package leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 1) {
            ranges.add(String.valueOf(nums[0]));
            return ranges;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            if (left == nums[i]) {
                sb.append(left);
            } else {
                sb.append(String.format("%d->%d", left, nums[i]));
            }
            ranges.add(sb.toString());
        }
        return ranges;
    }
}
