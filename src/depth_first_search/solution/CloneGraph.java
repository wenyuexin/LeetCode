package depth_first_search.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graph.utils.Node;

/** 
 * 基于DFS的图的遍历
 * 
 * @author Apollo4634 
 * @create 2019/03/24
 * @problem 133
 * @see depth_first_search.reference.CloneGraph_133
 */

public class CloneGraph {
	
	Map<Node, Node> marked;

	public Node cloneGraph(Node node) {
		marked = new HashMap<>();
		
		List<Node> newNeighbors = new ArrayList<>(node.neighbors.size());
		Node newGraph = new Node(node.val, newNeighbors);
        marked.put(node, newGraph);
        visit(node);
		return newGraph;
    }
	
	private void visit(Node prev) {
		Node prevCopy = marked.get(prev);
		for (Node neighbor: prev.neighbors) {
			Node neighborCopy = marked.get(neighbor);
			if (neighborCopy != null) {
				prevCopy.neighbors.add(neighborCopy);
				continue;
			}
			
			List<Node> newNeighbors = new ArrayList<>(neighbor.neighbors.size());
			neighborCopy = new Node(neighbor.val, newNeighbors);
			
			marked.put(neighbor, neighborCopy);
			prevCopy.neighbors.add(neighborCopy);
			visit(neighbor);
		}
	}
	
	
	public static void main(String[] args) {
		Node node = null;
		
		long t1 = System.nanoTime();
		CloneGraph obj = new CloneGraph();
		Node dummy = obj.cloneGraph(node);
		long t2 = System.nanoTime();
		
		System.out.println("output: "+dummy);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
