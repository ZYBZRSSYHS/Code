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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        bfs(root);
        return ans;
    }
    private void bfs(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index= 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> one = new ArrayList<>();
            while(size-->0){
                TreeNode n = queue.poll();
                one.add(n.val);
                
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
            if(index%2==0){
                Collections.reverse(one);
            }
            index++;
            ans.add(one);
        }
    }
}