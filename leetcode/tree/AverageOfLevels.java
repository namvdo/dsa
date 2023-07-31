package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double val = 0D;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    val += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            ans.add(val / size);
        }
        return ans;
    }
}
