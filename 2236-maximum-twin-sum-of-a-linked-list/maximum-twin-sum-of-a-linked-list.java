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
    public int pairSum(ListNode head) {
        // Step 1: Find the start of the second half
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half in-place
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Traverse both halves and compute the max twin sum
        int maxTwinSum = 0;
        ListNode first = head;
        ListNode second = prev; // Head of the reversed second half

        while (second != null) {
            maxTwinSum = Math.max(maxTwinSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return maxTwinSum;
    }
}