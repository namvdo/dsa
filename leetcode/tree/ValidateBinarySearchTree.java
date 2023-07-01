package leetcode.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean valid(TreeNode node, long left, long right) {
        if (node == null)
            return true;
        int val = node.val;
        if (!(val > left && val < right))
            return false;
        return valid(node.left, left, val) && valid(node.right, val, right);
    }
}
