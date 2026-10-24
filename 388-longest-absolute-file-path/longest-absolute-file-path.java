
class Solution {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int[] length = new int[parts.length + 1];
        int max = 0;

        for (String part : parts) {
            int level = part.lastIndexOf("\t") + 1;
            int nameLength = part.length() - level;

            if (part.contains(".")) {
                max = Math.max(max, length[level] + nameLength);
            } else {
                length[level + 1] = length[level] + nameLength + 1;
            }
        }

        return max;
    }
}
