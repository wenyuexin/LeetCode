package tree.solution;

import tree.utils.TreeNode;

/**
 * @author Apollo4634
 * @create 2019/08/16
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    static class Solution {
        private int[] preorder;
        private int[] inorder;
        private int preorderBuildingIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null && inorder == null) return null;
            if (preorder == null ^ inorder == null) return null;
            if (preorder.length != inorder.length) return null;
            this.inorder = inorder;
            this.preorder = preorder;
            preorderBuildingIndex = 0;
            return buildWithPreorder(0, preorder.length-1);
        }

        private TreeNode buildWithPreorder(int from, int to) {
            if (from > to) return null;
            int value = preorder[preorderBuildingIndex++];
            TreeNode root = new TreeNode(value);

            int pos = -1;
            for (int i = from; i <= to; i++) {
                if (inorder[i] == value) pos = i;
            }
            if (pos < 0) {
                throw new RuntimeException("Invalid inorder or preorder");
            }

            root.left = buildWithPreorder(from, pos-1);
            root.right = buildWithPreorder(pos+1, to);
            return root;
        }
    }
}
