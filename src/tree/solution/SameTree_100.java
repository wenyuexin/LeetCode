package tree.solution;

import tree.utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * @author Apollo4634
 * @create 2020/01/05
 * @problem 100
 * @tag Tree
 * @tag Depth-first Search
 */

public class SameTree_100 {
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return dfs(p, q);
        }

        private boolean dfs(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null ^ q == null) return false;
            if (p.val != q.val) return false;
            if (!dfs(p.left, q.left)) return false;
            return dfs(p.right, q.right);
        }
    }
}
