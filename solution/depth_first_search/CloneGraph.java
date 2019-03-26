package depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import graph.Node;

/** 
 * @author Apollo4634 
 * @create 2019/03/24
 * @problem 133
 * @see CloneGraph_133
 */

public class CloneGraph {
	
	public Node cloneGraph(Node node) {
        Map<Node, Boolean> marked = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
		Node dummy = new Node(node.val, null);
		
        marked.put(node, true);
		for (Node w: node.neighbors) {
			if (marked.containsKey(w)) continue;
			marked.put(w, true);
			//todo 复制w
			List<Node> neighbors = new ArrayList<>(w.neighbors.size());
		}
        
        
		return dummy;
    }
	
	public Node cloneNode(Node origin) {
		if (origin == null) return null;
		Node copy = new Node(origin.val, null);
		return copy;
	}
	
}
