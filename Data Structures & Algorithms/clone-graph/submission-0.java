/*
Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();

        return copy(map, node);
    }

    public Node copy(HashMap<Node, Node> map, Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);

        for (Node nei : node.neighbors) {
            clonedNode.neighbors.add(copy(map, nei));
        }

        return clonedNode;
    }
}