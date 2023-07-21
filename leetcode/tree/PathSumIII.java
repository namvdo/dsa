package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    long ans;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> count = new HashMap<>();
        count.put(0L, 1L);
        solve(root, 0, (long) targetSum, count);
        return (int) ans;
    }

    void solve(TreeNode root, long currSum, long target, Map<Long, Long> count) {
        if (root == null)
            return;
        long sum = currSum + root.val;
        if (count.containsKey(sum - target)) {
            ans += count.get(sum - target);
        }
        count.put(sum, count.getOrDefault(sum, 0L) + 1L);
        solve(root.left, currSum + root.val, target, count);
        solve(root.right, currSum + root.val, target, count);
        count.put(sum, count.get(sum) - 1);
    }
}
