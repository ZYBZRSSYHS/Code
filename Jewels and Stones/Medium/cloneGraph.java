/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        Map<Integer,Node> map = new HashMap<>();
        return cloneGrapthHelper(node,map);
    }
    private Node cloneGrapthHelper(Node node,Map<Integer,Node> map){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node n = new Node();
        n.val = node.val;
        n.neighbors=new ArrayList<Node>();
        map.put(node.val,n);
        for(Node temp:node.neighbors){
            n.neighbors.add(cloneGrapthHelper(temp,map));
        }
        return n;
    } 
}