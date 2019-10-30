class Solution{
    public Node connect(Node root){
        if(root==null){
            return null;
        }
        if(root.left!=null){
            if(root.right!=null){
                root.left.next = root.right;
            }else{
                root.left.next=findLeftChild(root);
            }
        }
        if(root.right !=null){
            root.right.next = findLeftChild(root);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    private Node findLeftChild(Node root){
        if(root.next == null){
            return null;
        }
        while(root.next!=null){
            if(root.next.left!=null){
                return root.next.left;
            }
            if(root.next.right!=null){
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}