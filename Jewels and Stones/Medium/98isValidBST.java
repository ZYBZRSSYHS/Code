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
    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node !=null || !stack.isEmpty()){
            while(node !=null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        if(ans.size()<2)
        return true;
        for(int i=0;i<ans.size()-1;i++){
            if(ans.get(i)>=ans.get(i+1))
            return false;
        }
        return true;
    }
}