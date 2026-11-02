import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int totalBoomerangs = 0;
        Map<Integer, Integer> distCounts = new HashMap<>();

        for (int[] p1 : points) {
            distCounts.clear();

            for (int[] p2 : points) {
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                int d2 = dx * dx + dy * dy;

                distCounts.put(d2, distCounts.getOrDefault(d2, 0) + 1);
            }

            for (int count : distCounts.values()) {
                if (count > 1) {
                    totalBoomerangs += count * (count - 1);
                }
            }
        }

        return totalBoomerangs;
    }
}