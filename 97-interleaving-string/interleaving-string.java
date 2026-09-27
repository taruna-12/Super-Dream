class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Use only s1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] &&
                       s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Use only s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] &&
                       s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int k = i + j - 1;

                // Take character from s1
                if (s1.charAt(i - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }

                // Take character from s2
                if (s2.charAt(j - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}