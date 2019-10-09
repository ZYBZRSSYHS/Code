/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        
        if(head==null||head.next==null){
        return true;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        ListNode next = null;
        while(head!=slow){
            next=head.next;
            head.next=pre;
            pre = head;
            head = next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        while(pre!=null){
            if(pre.val!=slow.val){
                return false;
            }
            pre=pre.next;
            slow=slow.next;
        }
        return true;
    }
}