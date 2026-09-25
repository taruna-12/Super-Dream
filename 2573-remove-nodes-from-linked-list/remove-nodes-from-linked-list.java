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
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Reverse the list to examine from right to left
        head = reverse(head);

        // Step 2: Filter out nodes smaller than the running maximum
        ListNode curr = head;
        int maxVal = curr.val;

        while (curr.next != null) {
            if (curr.next.val < maxVal) {
                // Remove curr.next
                curr.next = curr.next.next;
            } else {
                // Advance and update maximum seen so far
                curr = curr.next;
                maxVal = curr.val;
            }
        }

        // Step 3: Reverse back to restore the original order
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}