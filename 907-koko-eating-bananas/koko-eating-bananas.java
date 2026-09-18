class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            if (pile > right) {
                right = pile;
            }
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            // Equivalent to ceil((double) pile / k)
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}