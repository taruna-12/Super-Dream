class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] alice = new int[n + 1];
        int[] bob = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            alice[i] = i;
            bob[i] = i;
        }

        int used = 0;
        int aCount = 0;
        int bCount = 0;

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean a = union(edge[1], edge[2], alice);
                boolean b = union(edge[1], edge[2], bob);

                if (a || b) {
                    used++;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (union(edge[1], edge[2], alice)) {
                    used++;
                }
            } else if (edge[0] == 2) {
                if (union(edge[1], edge[2], bob)) {
                    used++;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (find(i, alice) != find(1, alice)) {
                return -1;
            }
            if (find(i, bob) != find(1, bob)) {
                return -1;
            }
        }

        return edges.length - used;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private boolean union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);

        if (pa == pb) {
            return false;
        }

        parent[pa] = pb;
        return true;
    }
}