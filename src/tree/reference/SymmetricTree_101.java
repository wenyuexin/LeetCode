package tree.reference;

import tree.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Apollo4634
 * @create 2020/01/21
 * @problem 101
 * @tag Tree
 * @tag Depth-first Search
 * @tag Breath-first Search
 * @see tree.solution.SymmetricTree_101
 */

public class SymmetricTree_101 {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        public boolean isMirror(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            return (t1.val == t2.val)
                    && isMirror(t1.right, t2.left)
                    && isMirror(t1.left, t2.right);
        }
    }


    static class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode t1 = q.poll();
                TreeNode t2 = q.poll();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.val != t2.val) return false;
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }
            return true;
        }
    }
}
