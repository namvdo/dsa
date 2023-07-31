package leetcode.tree;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    boolean hasPathSum(TreeNode root, int target, int accumulated) {
        if (root == null)
            return false;
        int total = root.val + accumulated;
        if (total == target && root.left == null && root.right == null)
            return true;
        boolean left = hasPathSum(root.left, target, total);
        boolean right = hasPathSum(root.right, target, total);
        return left || right;
    }
}
