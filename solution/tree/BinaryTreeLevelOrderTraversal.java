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
}


class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args){
        String line = "[0,1,2]";
        TreeNode root = stringToTreeNode(line);
        List<List<Integer>> ret = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        String out = int2dListToString(ret);
        System.out.print(out);
    }
}