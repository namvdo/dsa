package leetcode.tree;

public class ConstructInorderPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        int idx = -1;
        for(int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }
        int leftSize = idx - inStart;
        int rightSize = inEnd - idx;
        root.left = buildTree(inorder, inStart, idx - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, idx + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);
        return root;
    }
}
