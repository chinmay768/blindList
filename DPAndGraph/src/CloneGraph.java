import java.util.*;

public class CloneGraph {

    private class Node {
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

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();

        return cloneGraphDFS(node, map);
    }

    public Node cloneGraphDFS(Node node, Map<Integer, Node> map) {
        if(node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        for(Node adj : node.neighbors) {
            map.get(node.val).neighbors.add(cloneGraphDFS(adj, map));
        }

        return newNode;
    }

    public Node cloneGraphBFS(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        map.put(node.val, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for(Node adj : curr.neighbors) {
                if(!map.containsKey(adj.val)){
                    Node newNode = new Node(adj.val);
                    map.put(adj.val, newNode);
                    q.offer(adj);
                }

                map.get(curr.val).neighbors.add(map.get(adj.val));
            }
        }


        return map.get(node.val);
    }

    public static void main(String[] args) {

    }
}
