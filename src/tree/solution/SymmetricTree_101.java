package tree.solution;

import tree.utils.TreeNode;
import java.util.LinkedList;

/**
 * 这题可以用BFS或者DFS，
 * 如果用BFS可以将每一层的节点存放到一个双端队列中，
 * 然后判断队列中的节点是否对称
 *
 * @author Apollo4634
 * @create 2020/01/19
 * @problem 101
 * @tag Tree
 * @tag Depth-first Search
 * @tag Breath-first Search
 * @see tree.reference.SymmetricTree_101
 */

public class SymmetricTree_101 {
    //Unrecommended
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
