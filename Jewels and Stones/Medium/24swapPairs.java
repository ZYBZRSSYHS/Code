/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);

        ListNode p1 = head1;
        ListNode p2 = head2;
        
        while(head!=null){
            p1.next=head;
            head = head.next;
            p1 = p1.next;
            p1.next = null;

            if(head !=null){
                p2.next = head;
                head = head.next;
                p2= p2.next;
                p2.next=null;
            }
        }
        p1= head1.next;
        p2 = head2.next;
        head = new ListNode(0);
        ListNode p = head;
        while(p2!=null){
            p.next = p2;
            p2 = p2.next;
            p = p.next;
            p1 = p1.next;
            p = p.next;
            p.next = null;
        }
        p.next=p1;

        return head.next;
    }
}