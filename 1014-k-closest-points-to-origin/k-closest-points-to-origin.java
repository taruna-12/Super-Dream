class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Sort points based on distance from origin
        for (int i = 0; i < points.length - 1; i++) {

            for (int j = 0; j < points.length - i - 1; j++) {

                int d1 = points[j][0] * points[j][0]
                       + points[j][1] * points[j][1];

                int d2 = points[j + 1][0] * points[j + 1][0]
                       + points[j + 1][1] * points[j + 1][1];

                if (d1 > d2) {

                    int[] temp = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = temp;
                }
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }
}