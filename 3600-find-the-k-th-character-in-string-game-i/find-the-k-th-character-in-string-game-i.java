
class Solution {
    public char kthCharacter(int k) {
        String s = "a";

        while (s.length() < k) {
            String next = "";

            for (int i = 0; i < s.length(); i++) {
                next += (char) (s.charAt(i) + 1);
            }

            s += next;
        }

        return s.charAt(k - 1);
    }
}
