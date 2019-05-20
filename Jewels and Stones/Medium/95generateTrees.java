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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<>();
        return generateNodeList(1,n);
    }
    private List<TreeNode> generateNodeList(int si,int ei){
        List<TreeNode> res = new ArrayList<>();
        if(si>ei){
            res.add(null);
            return res;
        }
        if(si==ei){
            res.add(new TreeNode(si));
            return res;
        }
        for(int i=si;i<=ei;i++){
            List<TreeNode> leftSubTrees = generateNodeList(si,i-1);
            List<TreeNode> rightSubTrees = generateNodeList(i+1,ei);
            for(TreeNode left:leftSubTrees){
                for(TreeNode right:rightSubTrees){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}