package topological_sort.reference;

import java.util.LinkedList;
import java.util.List;


/** 
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
}
