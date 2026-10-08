import java.util.*;

class Solution {

    int[][] rects;
    long[] prefix;
    Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.random = new Random();

        prefix = new long[rects.length];

        long total = 0;

        for (int i = 0; i < rects.length; i++) {
            int x1 = rects[i][0];
            int y1 = rects[i][1];
            int x2 = rects[i][2];
            int y2 = rects[i][3];

            long points = (long) (x2 - x1 + 1) * (y2 - y1 + 1);

            total += points;
            prefix[i] = total;
        }
    }

    public int[] pick() {

        // Pick a random point number
        long target = (long) (random.nextDouble() * prefix[prefix.length - 1]) + 1;

        // Binary search for the rectangle
        int left = 0;
        int right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int[] rect = rects[left];

        int x1 = rect[0];
        int y1 = rect[1];
        int x2 = rect[2];
        int y2 = rect[3];

        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;

        int offset = (int) (target - (left == 0 ? 0 : prefix[left - 1]));

        int x = x1 + (offset - 1) % width;
        int y = y1 + (offset - 1) / width;

        return new int[]{x, y};
    }
}