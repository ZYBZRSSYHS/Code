/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int number=1;
        ListNode node=head;
        while(node!=null){
            node=node.next;
            number++;
            if(number==k){
                break;
            }
        }
        if(node==null){
            return head;
        }
        node = node.next;
        ListNode headt = head;

        ListNode pre=null;
        while(number!=0){
            ListNode next = head.next;
            head.next = pre;
            pre=head;
            head=next;
            number--;
        }
        headt.next=reverseKGroup(node, k);
        return pre;
    }
}