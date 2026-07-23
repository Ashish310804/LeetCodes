/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Continue while fast and its next node exist
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move 1 step
            fast = fast.next.next;     // Move 2 steps
            
            if (slow == fast) {
                return true;           // Cycle detected
            }
        }
        
        return false; // Reached end, no cycle
    }
    }