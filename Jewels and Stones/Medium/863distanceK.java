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
    Map<TreeNode,TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent=new HashMap();
        dfs(root,null);

        Queue<TreeNode> que = new LinkedList();
        que.add(null);
        que.add(target);

        Set<TreeNode> hs = new HashSet();
        hs.add(target);
        hs.add(null);

        int depth=0;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node==null){
                if(depth==K){
                    List<Integer> ans = new ArrayList();
                    for(TreeNode n:que){
                        ans.add(n.val);
                    }
                    return ans;
                }
                que.offer(null);
                depth++;
            }else{
                TreeNode tmp = parent.get(node);
                if(!hs.contains(tmp)){
                    que.offer(tmp);
                    hs.add(tmp);
                }
                if(!hs.contains(node.left)){
                    que.offer(node.left);
                    hs.add(node.left);
                }
                if(!hs.contains(node.right)){
                    que.offer(node.right);
                    hs.add(node.right);
                }
            }
        }
        return new ArrayList<Integer>();
    }
    public void dfs(TreeNode root,TreeNode node){
        if(root!=null){
            parent.put(root,node);
            dfs(root.left,root);
            dfs(root.right,root);
        }
    }
}