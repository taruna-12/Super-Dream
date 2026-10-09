
import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{score[i], i});
        }

        int rank = 1;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int index = current[1];

            if (rank == 1) {
                answer[index] = "Gold Medal";
            } else if (rank == 2) {
                answer[index] = "Silver Medal";
            } else if (rank == 3) {
                answer[index] = "Bronze Medal";
            } else {
                answer[index] = String.valueOf(rank);
            }

            rank++;
        }

        return answer;
    }
}
