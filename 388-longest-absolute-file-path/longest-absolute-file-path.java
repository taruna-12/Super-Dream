class Solution {
    public int lengthLongestPath(String input) {

        String[] lines = input.split("\n");

        int[] length = new int[lines.length + 1];
        int answer = 0;

        for (String line : lines) {

            int depth = 0;

            while (depth < line.length() && line.charAt(depth) == '\t') {
                depth++;
            }

            String name = line.substring(depth);

            // If depth is 0, there is no parent directory
            if (depth == 0) {
                length[depth] = name.length() + 1;
            } else {
                length[depth] = length[depth - 1] + name.length() + 1;
            }

            // Check if it is a file
            if (name.contains(".")) {
                answer = Math.max(answer, length[depth] - 1);
            }
        }

        return answer;
    }
}