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
    private TreeNode node=null;
    private int mid=0;
    private int left=0;
    private int right=0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        findx(root,x);

        if(node.left!=null){
            left(node.left);
        }
        if(node.right!=null){
            right(node.right);
        }
        mid = n-left-right-1;

        return mid>(n>>1)||left>(n>>1)||right>(n>>1);
    }
    private void findx(TreeNode root,int x){
        if(root.val==x){
            node = root;
            return;
        }else{
            if(root.left!=null){
                findx(root.left,x);
            }
            if(root.right!=null){
                findx(root.right,x);
            }
        }
        return;
    }
    public void left(TreeNode root){
        if(root!=null){
            left++;
            left(root.left);
            left(root.right);
        }
    }

    public void right(TreeNode root){
        if(root!=null){
            right++;
            right(root.right);
            right(root.left);
        }
    }
}