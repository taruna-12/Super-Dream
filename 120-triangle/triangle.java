import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        // Initialize dp with the bottom row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Work upwards from row n - 2 to 0
        for (int row = n - 2; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            for (int col = 0; col <= row; col++) {
                dp[col] = currentRow.get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        
        return dp[0];
    }
}