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
    public ListNode deleteMiddle(ListNode head) {
        // Base case: 0 or 1 node
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow at head, fast two steps ahead
        // This ensures 'slow' ends up right before the middle node
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        slow.next = slow.next.next;

        return head;
    }
}