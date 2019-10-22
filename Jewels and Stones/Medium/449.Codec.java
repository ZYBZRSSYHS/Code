/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {
    private int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root,sb);
        return sb.toString();
    }

    private void doSerialize(TreeNode root,StringBuilder sb){
        if(root!=null){
            sb.append(root.val+"_");
            doSerialize(root.left,sb);
            doSerialize(root.right,sb);
        }else{
            sb.append("#_");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split("_");
        if(s==null||s.length==0){
            return null;
        }
        i=0;
        return doDeserialize(s);
    }
    
    private TreeNode doDeserialize(String[] s){
        if(s[i].equals("#")){
            ++i;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[i++]));
        root.left=doDeserialize(s);
        root.right=doDeserialize(s);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));