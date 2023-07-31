package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode right = null;
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    right = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (right != null) {
                ans.add(right.val);
            }
        }
        return ans;
    }
}
