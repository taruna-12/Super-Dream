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
    public ListNode mergeNodes(ListNode head) {
        ListNode write = head.next; // Pointer to update sum values
        ListNode curr = head.next;  // Pointer to traverse and aggregate values

        while (curr != null) {
            int sum = 0;
            
            // Accumulate values until hitting the next zero boundary
            while (curr != null && curr.val != 0) {
                sum += curr.val;
                curr = curr.next;
            }

            // Write the accumulated sum into the list
            write.val = sum;

            // Move curr past the '0' node
            curr = curr.next;

            // Link to the next node to write, or terminate if at the end
            write.next = curr;
            if (curr != null) {
                write = write.next;
            }
        }

        return head.next;
    }
}