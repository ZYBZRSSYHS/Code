/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Solution {
    public Node connect(Node root) {

        if (root == null)
            return root;
        Node cur = root;
        Node pre = null;
        
        while(cur!=null){
            while(pre!=null){
                pre.left.next=pre.right;
                if(pre.next !=null){
                    pre.right.next=pre.next.left;
                }
                pre = pre.next;
            }
            pre=cur;
            cur = cur.left;
        }
        return root;
    }
}