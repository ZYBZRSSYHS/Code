/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SolutionIteration {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
       ListNode pre=null;
       ListNode ind=head;

        while(ind!=null){
            ListNode tmp = ind.next;
            ind.next=pre;
            pre=ind;
            ind=tmp;
        }
        return pre;
    }
}