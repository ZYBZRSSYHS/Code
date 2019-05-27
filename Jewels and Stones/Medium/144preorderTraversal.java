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
    public List<Integer> preorderTraversal(TreeNode root) {
        return new ArrayList(){{
            if(root!=null){
                    add(root.val);
                    addAll(preorderTraversal(root.left));
                    addAll(preorderTraversal(root.right));
            }
        }
        };
    }
}