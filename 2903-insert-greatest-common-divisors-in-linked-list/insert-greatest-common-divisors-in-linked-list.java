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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int gcdVal = gcd(curr.val, curr.next.val);
            
            // Create the new GCD node pointing to curr.next
            ListNode gcdNode = new ListNode(gcdVal, curr.next);
            
            // Link current node to the new GCD node
            curr.next = gcdNode;
            
            // Move curr to the original next node
            curr = gcdNode.next;
        }

        return head;
    }

    // Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}