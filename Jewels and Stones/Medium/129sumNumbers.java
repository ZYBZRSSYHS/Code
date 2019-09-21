import org.graalvm.compiler.core.common.alloc.Trace;

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
    public int sumNumbers(TreeNode root) {
        if(root!=null){
            Tree(root,root.val);
        }
        return sum;
    }
    int sum=0;
    private void Tree(TreeNode tree,int num){
        if(tree.left==null && tree.right==null){
            sum+=num;
            return ;
        }
        
        if(tree.left!=null){
            Tree(tree.left,num*10+tree.left.val);
        }

        if(tree.right!=null){
            Tree(tree.right,num*10+tree.right.val);
        }
    }
}