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
    Map<Integer,Integer> arr = new HashMap();
    List<Integer> ans = new ArrayList<Integer>();
    int size = 0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return ans;
        }
        cx(root,0);
        for(int i=0;i<=size;i++){
            ans.add(arr.get(i));
        }
        return ans;
    }
    private void cx(TreeNode root,int depth){
        arr.put(depth,root.val);
        if(root.left!=null){
            cx(root.left,depth+1);
        }
        if(root.right!=null){
            cx(root.right,depth+1);
        }
        if(depth>size){
            size = depth;
        }
    }
}