package depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graph.Node;

/** 
 * @author Apollo4634 
 * @create 2019/03/28
 * @problem 133
 * @see CloneGraph
 */

public class CloneGraph_133 {
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
}
