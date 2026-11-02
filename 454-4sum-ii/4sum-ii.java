import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        
        // Count frequencies of all pairwise sums from nums1 and nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }
        
        int totalTuples = 0;
        
        // Find matching complements from nums3 and nums4
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                totalTuples += sumCount.getOrDefault(target, 0);
            }
        }
        
        return totalTuples;
    }
}