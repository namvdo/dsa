package leetcode.tree;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || (p != null && q == null)) return false;
        if (p == null && q == null) return true;
        boolean same = p.val == q.val;
        return same && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
