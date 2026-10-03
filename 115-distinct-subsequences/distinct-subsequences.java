class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        
        // Use double or unsigned-equivalent tracking internally if intermediate steps exceed 32-bit,
        // but standard integer / long handles typical constraints cleanly.
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int i = 0; i < m; i++) {
            char cs = s.charAt(i);
            for (int j = n; j >= 1; j--) {
                if (cs == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return (int) dp[n];
    }
}