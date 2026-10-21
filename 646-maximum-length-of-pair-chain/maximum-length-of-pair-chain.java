import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort pairs by second element
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int chainLen = 0;
        int currEnd = Integer.MIN_VALUE;
        
        for (int[] pair : pairs) {
            // First element or strictly increasing without overlap
            if (chainLen == 0 || pair[0] > currEnd) {
                currEnd = pair[1];
                chainLen++;
            }
        }
        
        return chainLen;
    }
}