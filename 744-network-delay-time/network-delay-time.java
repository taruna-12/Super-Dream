class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            graph[time[0]].add(
                new int[]{time[1], time[2]}
            );
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int distance = current[1];

            if (distance > dist[node]) {
                continue;
            }

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int newDist = distance + edge[1];

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.add(new int[]{next, newDist});
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}