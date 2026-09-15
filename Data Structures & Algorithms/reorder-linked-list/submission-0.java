/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slw = head;
        ListNode fst = head;

        while(fst != null && fst.next != null){
            slw = slw.next;
            fst = fst.next.next;
        }
        ListNode sf = slw.next;

        slw.next = null;
        ListNode prv = null;

        while(sf != null){
            ListNode nxt = sf.next;
            sf.next = prv;
            prv = sf;
            sf = nxt;
        }
        sf = prv;

        ListNode fir = head;
        while(sf != null){
            ListNode tmp1 = fir.next;
            ListNode tmp2 = sf.next;

            fir.next = sf;
            sf.next = tmp1;

            fir = tmp1;
            sf = tmp2;
        }
    }
}
