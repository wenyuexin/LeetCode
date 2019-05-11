package graph.utils;

import java.util.List;

/** 
 * Definition for a Node
 * 
 * @author Apollo4634 
 * @create 2019/03/24
 * @related Graph
 * @related Depth-first Search
 * @related Breadth-first Search
 */

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
