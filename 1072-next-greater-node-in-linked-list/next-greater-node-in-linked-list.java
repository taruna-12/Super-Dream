import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

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
    public int[] nextLargerNodes(ListNode head) {
        // Step 1: Collect all node values into an array list
        ArrayList<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int n = values.size();
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        // Step 2: Use a monotonic decreasing stack
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                int prevIndex = stack.pop();
                result[prevIndex] = values.get(i);
            }
            stack.push(i);
        }

        return result;
    }
}