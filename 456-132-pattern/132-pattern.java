class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return false;
        }

        int second = Integer.MIN_VALUE;
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // nums[i] is the "1"
            if (nums[i] < second) {
                return true;
            }

            // Find the largest possible "2"
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}