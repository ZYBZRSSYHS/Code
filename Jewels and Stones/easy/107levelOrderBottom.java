import java.util.ArrayList;



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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            DFS(root,0,ans);
            return ans;
    }
    private void DFS(TreeNode root,int level,List<List<Integer>> ans){
        if(root ==null){
            return;
        }
        if(ans.size()<=level){
            ans.add(0,new ArrayList<>());
        }
        ans.get(ans.size()-1-level).add(root.val);

        DFS(root.left,level+1,ans);
        DFS(root.right,level+1,ans);
    }
}