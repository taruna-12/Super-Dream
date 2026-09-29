class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean forward = nums[i] > 0;
            int curr = i;

            for (int count = 0; count < n; count++) {
                if (nums[curr] == 0)
                    break;

                if ((nums[curr] > 0) != forward)
                    break;

                int next = ((curr + nums[curr]) % n + n) % n;

                if (next == curr)
                    break;

                curr = next;

                if (curr == i)
                    return true;
            }
        }

        return false;
    }
}