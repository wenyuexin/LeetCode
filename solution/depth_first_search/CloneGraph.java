package depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import array.ContainerWithMostWater;
import graph.Node;

/** 
 * @author Apollo4634 
 * @create 2019/03/24
 * @problem 133
 * @see CloneGraph_133
 */

public class CloneGraph {
	
	Map<Node, Node> marked;
	Queue<Node> queue;

	public Node cloneGraph(Node node) {
		marked = new HashMap<>();
		queue = new LinkedList<>();
		
		Node dummy = new Node(node.val, null);
        marked.put(node, dummy);
        visit(node);
		return dummy;
    }
	
	private void visit(Node node) {
		for (Node w: node.neighbors) {
			if (marked.containsKey(w)) continue;
			marked.put(w, node);
			
			Node copy = cloneNode(w);
			copy.neighbors.add(marked.get(node));
			visit(w);
			
			
		}
	}
	
	private static Node cloneNode(Node origin) {
		if (origin == null) return null;
		List<Node> neighbors = new ArrayList<>(origin.neighbors.size());
		Node copy = new Node(origin.val, neighbors);
		return copy;
	}
	
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		long t1 = System.nanoTime();
		ContainerWithMostWater obj = 
				new ContainerWithMostWater();
		int maxValue = obj.maxArea2(height);
		long t2 = System.nanoTime();
		
		System.out.println("output: "+maxValue);
		System.out.println("Rumtime: "+(t2-t1)/1.0E6+" ms");
	}
}
