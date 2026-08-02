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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create dummy node - handles edge case when removing head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Two pointers: first and second start at dummy
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer n + 1 steps ahead
        // This creates a gap of n nodes between first and second
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches null
        // When first is at null, second is at node before target
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node from end
        second.next = second.next.next;
        
        return dummy.next; // Return actual head (may have changed if removed original head)
    }
}