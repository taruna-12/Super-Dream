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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Less than 3 nodes cannot form any critical point
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstIndex = -1;
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 2; // curr starts at 1-based index 2

        while (curr.next != null) {
            boolean isLocalMaxima = curr.val > prev.val && curr.val > curr.next.val;
            boolean isLocalMinima = curr.val < prev.val && curr.val < curr.next.val;

            if (isLocalMaxima || isLocalMinima) {
                if (firstIndex == -1) {
                    firstIndex = currentIndex;
                } else {
                    minDistance = Math.min(minDistance, currentIndex - prevIndex);
                }
                prevIndex = currentIndex;
            }

            prev = curr;
            curr = curr.next;
            currentIndex++;
        }

        // Fewer than 2 critical points were detected
        if (firstIndex == -1 || prevIndex == firstIndex) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevIndex - firstIndex;
        return new int[]{minDistance, maxDistance};
    }
}