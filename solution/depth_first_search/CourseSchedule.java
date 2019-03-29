package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;

import graph.Node;

/** 
 * 
 * 
 * @author Apollo4634 
 * @create 2019/03/29
 * @problem 207
 * @related Depth-first Search
 * @related Breadth-first Search
 * @related Graph
 * @related Topological Sort
 * @see CourseSchedule_207
 */

public class CourseSchedule {

	private Node[] nodeList;
	private boolean[] marked;
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		nodeList = new Node[numCourses+1];
		marked = new boolean[numCourses+1];
		
        Node root = new Node(0, new ArrayList<Node>(numCourses));
		for (int i = 0; i < numCourses+1; i++) {
			nodeList[i] = new Node(i, new LinkedList<Node>());
			root.neighbors.add(nodeList[i]);
		}
		
		for (int i = 0; i < numCourses; i++) {
			for (int j = 0; j < prerequisites[i].length; j++) {
				nodeList[i].neighbors.add(nodeList[prerequisites[i][j]]);
			}
		}
		
		visit(0);
		
		return true;
    }
	
	private void visit(int i) {
		for (Node node : nodeList[i].neighbors) {
			if (marked[i]) {
				
			}
		}
	}
}
