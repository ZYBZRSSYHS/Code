/**
 * Definition for a binary tree node.

 */
class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left=deleteNode(root.left, key);
            return root;
        }else if(key>root.val){
            root.right=deleteNode(root.right, key);
            return root;
        }else{
            if(root.left==null){
                TreeNode right = root.right;
                root.right = null;
                return right;
            }
            if(root.right == null){
                TreeNode left = root.left;
                root.left = null;
                return left;
            }

            TreeNode rMin = minimun(root.right);
            rMin.right = removeMin(root.right);
            rMin.left = root.left;
            root.left = root.right=null;
            return rMin;
        }
    }

    private TreeNode minimun(TreeNode node){
        if(node.left == null){
            return node;
        }
        return minimun(node.left);
    }
    private TreeNode removeMin(TreeNode node){
        if(node.left==null){
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }
}