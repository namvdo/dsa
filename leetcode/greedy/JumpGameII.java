package leetcode.greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        int res = 0;
        int left = 0, right = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for(int i = left; i <= right; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            left = right + 1;
            right = farthest;
            res += 1;
        }
        return res;
    }
}
