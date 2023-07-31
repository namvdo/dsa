package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator {
   LinkedList<TreeNode> queue = new LinkedList<>();

    public BinarySearchTreeIterator(TreeNode root) {
        inorder(root, queue);
    }

    void inorder(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) return;
        inorder(root.left, queue);
        queue.add(root);
        inorder(root.right, queue);
    }
    
    public int next() {
        return queue.removeFirst().val;
    }
    
    public boolean hasNext() {
       return !queue.isEmpty();
    } 
}
