package leetcode.tree;

public class FlattenTreeToLinkedList {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);
        if (root.left != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }
}
