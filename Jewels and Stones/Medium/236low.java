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
    Deque<TreeNode> stack = new ArrayDeque<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root,null);
        stack.push(root);

        while(!parent.containsKey(p)||!parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left!=null){
                parent.put(node.left,node);
                stack.push(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}