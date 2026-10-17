import java.util.*;

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int required = 0;
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(b[2], a[2]));

        for (int[] edge : edges) {
            if (edge[3] == 1) {
                required++;
                if (!union(parent, size, edge[0], edge[1])) {
                    return -1;
                }
            }
        }

        if (required > n - 1) {
            return -1;
        }

        int low = 1;
        int high = 200000;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBuild(n, edges, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (edge[3] == 1) {
                if (edge[2] < target) {
                    return false;
                }

                if (!union(parent, size, edge[0], edge[1])) {
                    return false;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[3] == 0 && edge[2] >= target) {
                union(parent, size, edge[0], edge[1]);
            }
        }

        int upgrades = 0;

        for (int[] edge : edges) {
            if (edge[3] == 0 && edge[2] < target
                    && 2L * edge[2] >= target) {
                if (union(parent, size, edge[0], edge[1])) {
                    upgrades++;
                }
            }
        }

        if (upgrades > k) {
            return false;
        }

        int root = find(parent, 0);

        for (int i = 1; i < n; i++) {
            if (find(parent, i) != root) {
                return false;
            }
        }

        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private boolean union(int[] parent, int[] size, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA == rootB) {
            return false;
        }

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];

        return true;
    }
}