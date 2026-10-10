import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[2] - b[2]);

        dist[0][0] = grid.get(0).get(0);
        pq.offer(new int[]{0, 0, grid.get(0).get(0)});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

            if (cost > dist[x][y]) {
                continue;
            }

            if (x == m - 1 && y == n - 1) {
                return cost < health;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = cost + grid.get(nx).get(ny);

                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }

        return false;
    }
}