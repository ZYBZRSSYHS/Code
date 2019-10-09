import java.util.ArrayList;

import jdk.nashorn.api.tree.Tree;
import sun.tools.java.Scanner;

/**
一次中序遍历得到一个排序好的链表，然后更改左右节点指针得到一个双向的链表
*/
public class Convert{
    public static void main(String[] args) {
        ListNode list = new ListNode();
        java.util.Scanner sc = new Scanner(System.in);
        sc.nextInt();
        System.out.println(sc);
    }
    
    public class ListNode{
        int val = 0;
        ListNode next=null;
        public ListNode(int val){
            this.val = val;
        }
    }



    public class TreeNode{
        int val=0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode next = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree,list);
        return Convert(list);
    }

    public void Convert(TreeNode pRootOfTree,ArrayList<TreeNode> list){
        if(pRootOfTree.left!=null){
            Convert(pRootOfTree.left,list);
        }
        list.add(pRootOfTree);
        if(pRootOfTree.right!=null){
            Convert(pRootOfTree.right,list);
        }
    }

    public TreeNode Convert(ArrayList<TreeNode> list){
        for(int i=0;i<list.size()-1;i++){
            list.get(i).right=list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }
}