package topological_sort.solution;

import java.util.LinkedList;
import java.util.List;


/** 
 * @author Apollo4634 
 * @create 2019/03/31
 * @problem 207
 * @related Depth-first Search
 * @related Breadth-first Search
 * @related Graph
 * @related Topological Sort
 * @see CourseSchedule_207
 */

public class CourseSchedule {

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
				adjList[prerequisites[i][1]] = new LinkedList<Integer>();
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
	
	
	public static void main(String[] args) {
		int numCourses = 2;
		//int[][] prerequisites = new int[][] {{1,0}};
		int[][] prerequisites = new int[][] {{1,0},{0,1}};
		
		System.out.println("Input: "+numCourses);
		System.out.println("Input: "+java.util.Arrays.deepToString(prerequisites));
		
		long t1 = System.nanoTime();
		CourseSchedule obj = new CourseSchedule();
		boolean flag = obj.canFinish(numCourses, prerequisites);
		long t2 = System.nanoTime();
		
		System.out.println("Output: "+flag);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
