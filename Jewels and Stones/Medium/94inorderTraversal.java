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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode T = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(T!=null||!stack.isEmpty()){
            while(T!=null){
                stack.push(T);
                T = T.left;
            }
            if(!stack.isEmpty()){
                T = stack.pop();
                list.add(T.val);
                T = T.right;
            }
        }
        return list;
    }
}