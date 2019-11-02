/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    int zz = 0;
    List<Integer> ans = new ArrayList();

    public BSTIterator(TreeNode root) {
        bs(root);
    }

    public void bs(TreeNode root){
        if(root==null){
            return;
        }
        bs(root.left);
        ans.add(root.val);
        bs(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return ans.get(zz++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(zz<ans.size()){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */