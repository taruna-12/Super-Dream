class Solution {
    public String countAndSay(int n) {

        String s = "1";

        for (int k = 1; k < n; k++) {

            String ans = "";
            int i = 0;

            while (i < s.length()) {

                int count = 1;

                while (i + 1 < s.length() &&
                       s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                    i++;
                }

                ans = ans + count + s.charAt(i);

                i++;
            }

            s = ans;
        }

        return s;
    }
}