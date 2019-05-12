package topological_sort.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/**
 * Solution 1
 *
 *
 * Solution 2
 *
 * 从图的角度思考，假设一门课程是一个节点，
 * 如果课程i必须在课程j之前学习，那么就在节点i到节点j之间添加有向边。
 * 那么，本题中的课程安排实际上是优先级限制下的调度问题，
 * 实质上是判断节点具有先后顺序的有向图能否进行拓扑排序，
 * 而拓扑排序的前提条件是不存在有向环，因此本题可以转换为有向环的存在性判断
 *
 * @author Apollo4634 
 * @create 2019/03/31
 * @problem 207
 * @tag Depth-first Search
 * @tag Breadth-first Search
 * @tag Graph
 * @tag Topological Sort
 * @see topological_sort.reference.CourseSchedule_207
 */

public class CourseSchedule_207 {

	public static class Solution {
		private List<Integer>[] adjList;
		private boolean[] marked;
		private boolean[] onStack;

		@SuppressWarnings("unchecked")
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			adjList = (List<Integer>[]) new LinkedList[numCourses];
			marked = new boolean[numCourses];
			onStack = new boolean[numCourses];

			for (int i = 0; i < prerequisites.length; i++) {
				if (adjList[prerequisites[i][1]] == null)
					adjList[prerequisites[i][1]] = new LinkedList<>();
				adjList[prerequisites[i][1]].add(prerequisites[i][0]);
			}

			for (int i = 0; i < numCourses; i++) {
				if (adjList[i] == null) continue;
				if (!visit(i)) return false;
			}
			return true;
		}

		private boolean visit(int i) {
			if (adjList[i] == null) return true;
			marked[i] = true;
			onStack[i] = true;
			for (int node : adjList[i]) {
				if (onStack[node]) return false;
				if (!marked[node] && !visit(node)) return false;
			}
			onStack[i] = false;
			return true;
		}
	}


	public static class Solution2 {
		private class Node {
			public int val;
			private List<Node> neighbors;
			Node(int _val,List<Node> _neighbors) {
				val = _val;
				neighbors = _neighbors;
			}
		}

		private Node[] nodeList;
		private boolean[] marked;
		private boolean[] onStack;

		public boolean canFinish(int numCourses, int[][] prerequisites) {
			nodeList = new Node[numCourses+1];
			marked = new boolean[numCourses+1];
			onStack = new boolean[numCourses+1];

			Node root = new Node(numCourses, new ArrayList<>(numCourses));
			nodeList[numCourses] = root;
			for (int i = 0; i < numCourses; i++) {
				nodeList[i] = new Node(i, new LinkedList<>());
				root.neighbors.add(nodeList[i]);
			}

			for (int[] arr: prerequisites) {
				nodeList[arr[1]].neighbors.add(nodeList[arr[0]]);
			}

			return visit(numCourses);
		}

		private boolean visit(int i) {
			marked[i] = true;
			onStack[i] = true;
			for (Node node : nodeList[i].neighbors) {
				if (!marked[node.val]) visit(node.val);
				else if (onStack[node.val]) return false;
			}
			onStack[i] = false;
			return true;
		}
	}


	public static void main(String[] args) {
		int numCourses = 2;
		//int[][] prerequisites = new int[][] {{1,0}};
		int[][] prerequisites = new int[][] {{1,0},{0,1}};
		
		System.out.println("Input: "+numCourses);
		System.out.println("Input: "+Arrays.deepToString(prerequisites));
		
		long t1 = System.nanoTime();
		Solution obj = new Solution();
		boolean flag = obj.canFinish(numCourses, prerequisites);
		long t2 = System.nanoTime();
		
		System.out.println("Output: "+flag);
		System.out.println("Runtime: "+(t2-t1)/1.0E6+" ms");
	}
}
