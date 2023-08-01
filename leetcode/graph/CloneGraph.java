package leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        LinkedList<Node> queue = new LinkedList<>();
        LinkedHashMap<Node, Node> map = new LinkedHashMap<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node srcNode = queue.removeFirst();
            if (!visited.contains(srcNode)) {
                Node newNode = new Node(srcNode.val);
                map.put(srcNode, newNode);
                visited.add(srcNode);
                List<Node> neighbors = srcNode.neighbors;
                for (Node n : neighbors) {
                    if (n != null) {
                        queue.addLast(n);
                    }
                }
            }
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node key = entry.getKey();
            List<Node> neighbors = key.neighbors;
            List<Node> clonedNeighbors = new ArrayList<>();
            for (Node n : neighbors) {
                clonedNeighbors.add(map.get(n));
            }
            Node val = entry.getValue();
            val.neighbors = clonedNeighbors;
        }
        return map.entrySet().iterator().next().getValue();
    }
}