package leetcode.tree;

public class SumRootToLeaves {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, "", 0);
    }

    int sumNumbers(TreeNode root, String num, int total) {
        if (root == null) return total;
        int val = root.val;
        num += val;
        if (root.left == null && root.right == null) {
            total += Integer.parseInt(num);
            return total;
        }
        return sumNumbers(root.left, num, total) + sumNumbers(root.right, num, total);
    }
}
