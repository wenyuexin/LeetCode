package tree.solution;

import tree.utils.TreeNode;

import java.util.LinkedList;

public class SymmetricTree_101 {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add(root.left);
            nodes.add(root.right);
            return bfs(nodes);
        }

        private boolean bfs(LinkedList<TreeNode> currentLayer) {
            LinkedList<TreeNode> nextLayer;
            while (!currentLayer.isEmpty()) {
                nextLayer = new LinkedList<>();
                while (!currentLayer.isEmpty()) {
                    TreeNode firstNode = currentLayer.pollFirst();
                    TreeNode lastNode = currentLayer.pollLast();
                    if (firstNode == null && lastNode == null) continue;
                    if (firstNode == null ^ lastNode == null) return false;
                    if (firstNode.val != lastNode.val) return false;
                    nextLayer.addFirst(firstNode.left);
                    nextLayer.addFirst(firstNode.right);
                    nextLayer.addLast(lastNode.right);
                    nextLayer.addLast(lastNode.left);
                }
                currentLayer = nextLayer;
            }
            return true;
        }
    }
}
