package leetcode.tree;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        boolean t = false;
        if (left == null && right == null) return true;
        else if ((left == null && right != null) || (left != null && right == null)) return false;
        else {
            t = left.val == right.val;
        }
        return t && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
