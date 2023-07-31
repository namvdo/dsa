package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        boolean left = true;
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            if (left) {
                while (size-- != 0) {
                    TreeNode node = queue.removeFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            } else {
                Stack<TreeNode> stack = new Stack<>();
                while (size-- != 0) {
                    TreeNode node = queue.removeFirst();
                    stack.add(node);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                while (!stack.isEmpty()) {
                    list.add(stack.pop().val);
                }
            }
            left = !left;
            ans.add(list);
        }
        return ans;
    }
}
