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
    public boolean hasCycle(ListNode head) {
        ListNode fst = head;
        ListNode slw = head;

        while(fst != null && fst.next != null){
            slw = slw.next;
            fst = fst.next.next;

            if(slw == fst){
                 return true;
            }
        }
        return false;
    }
}
