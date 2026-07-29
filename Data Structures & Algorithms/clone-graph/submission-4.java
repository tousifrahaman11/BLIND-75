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
    private Map<Node, Node> mp = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(mp.containsKey(node)){
            return mp.get(node);
        }
        Node cl = new Node(node.val);
        mp.put(node, cl);

        for(Node neig : node.neighbors){
            cl.neighbors.add(cloneGraph(neig));
        }
        return cl;
    }
}