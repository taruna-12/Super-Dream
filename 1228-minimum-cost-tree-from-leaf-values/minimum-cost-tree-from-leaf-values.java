import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        // Sentinel INT_MAX avoids empty stack checks
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        
        for (int num : arr) {
            // Maintain a strictly decreasing stack
            while (stack.peek() <= num) {
                int mid = stack.pop();
                // Merge mid with the smaller of its left neighbor and current element
                res += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        
        // Clear remaining elements in decreasing order
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        
        return res;
    }
}
