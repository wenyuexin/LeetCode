package tree.solution;

import tree.utils.TreeNode;

/**
 * @author Apollo4634
 * @create 2020/01/21
 * @problem 104
 * @tag Tree
 * @tag Depth-first Search
 */

public class MaximumDepthOfBinaryTree_104 {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int depth) {
            if (node == null) return depth;
            int n1 = dfs(node.left, depth+1);
            int n2 = dfs(node.right, depth+1);
            return Math.max(n1, n2);
        }
    }
}
