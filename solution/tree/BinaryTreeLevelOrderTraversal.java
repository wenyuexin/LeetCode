package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
 * @author Apollo4634 
 * @create 2019/03/31
 * @problem 102
 * @related Tree
 * @related Breadth-first Search
 * @see BinaryTreeLevelOrderTraversal_102
 */

public class BinaryTreeLevelOrderTraversal {

	LinkedList<List<Integer>> levelOrderList;
	Queue<TreeNode> queue;
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		levelOrderList = new LinkedList<>();
		queue = new LinkedList<>();
		
		List<Integer> tempList = Arrays.asList(root.val);
		queue.add(root);
		levelOrderList.add(tempList);
		
		while (!queue.isEmpty()) {
			for (TreeNode node : queue) {
				tempList = new LinkedList<Integer>();
				tempList.add(node.val);
			}
		}
		
		return (List<List<Integer>>) levelOrderList;
    }
	
	
	private void visit(TreeNode i, int currentLevel) {
		
	}
}
