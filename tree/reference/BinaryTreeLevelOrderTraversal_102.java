package tree.reference;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
 * @author Apollo4634 
 * @create 2019/03/31
 * @problem 102
 * @tag Tree
 * @tag Breadth-first Search
 * @see tree.solution.BinaryTreeLevelOrderTraversal_102
 */

public class BinaryTreeLevelOrderTraversal_102 {

	//My Approch - based on BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelOrderList = new LinkedList<>();
		if (root == null) return levelOrderList;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode nextLevel = new TreeNode(-1);
		
		queue.add(root);
		queue.add(nextLevel);
		List<Integer> tempList = new LinkedList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node != nextLevel) {				
				tempList.add(node.val);
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			} else {
				levelOrderList.add(tempList);
				if (queue.isEmpty()) break;
				tempList = new LinkedList<Integer>();
				queue.add(nextLevel);
			}
		}
		return levelOrderList;
    }
	
	//Others - based on pre-order traversal
	public void levelOrder(TreeNode root, Integer level, List<List<Integer>> list) {
        if (root == null) return;

        List<Integer> result;
        if (list.size() <= level)
            list.add(result = new ArrayList<>());
        else
            result = list.get(level);

        result.add(root.val);
        levelOrder(root.left, level + 1, list);
        levelOrder(root.right, level + 1, list);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }
}
