import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        
        // 1. Flatten the 2x3 board into a 6-character string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        
        if (start.equals(target)) {
            return 0;
        }

        // 2. Predefined valid index swaps for each position 0 to 5
        int[][] directions = {
            {1, 3},       // index 0
            {0, 2, 4},    // index 1
            {1, 5},       // index 2
            {0, 4},       // index 3
            {1, 3, 5},    // index 4
            {2, 4}        // index 5
        };

        // 3. BFS structures
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            moves++;

            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();
                int zeroIdx = current.indexOf('0');

                for (int nextIdx : directions[zeroIdx]) {
                    String nextState = swap(current, zeroIdx, nextIdx);

                    if (nextState.equals(target)) {
                        return moves;
                    }

                    if (visited.add(nextState)) {
                        queue.offer(nextState);
                    }
                }
            }
        }

        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}