/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode t1,t2,pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val=t2.val;
        t2.val=temp;
    }
    public void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        if(pre !=null && pre.val>root.val){
            if(t1==null)
            t1=pre;
            t2=root;
        }
        pre=root;
        inorder(root.right);
    }
}