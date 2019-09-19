import java.util.ArrayList;

import com.sun.tools.javac.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root,sum,res,new ArrayList<Integer>());
        return res;
    }

    public void helper(TreeNode root,int sum,List<List<Integer>> res,ArrayList<Integer> tmp){
        if(root == null){
            return;
        }
        tmp.add(root.val);
        if(root.left==null && root.right == null && sum-root.val == 0){
            res.add(new ArrayList<>(tmp));
        }
        helper(root.left, sum-root.val, res, tmp);
        helper(root.right, sum-root.val, res, tmp);
        tmp.remove(tmp.size()-1);
    }

}