import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Sort words by length in ascending order
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        Set<String> wordSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            // Use memoization table: 0 = unvisited, 1 = true, -1 = false
            int[] memo = new int[word.length()];
            if (dfs(word, 0, wordSet, memo)) {
                result.add(word);
            }
            wordSet.add(word);
        }

        return result;
    }

    private boolean dfs(String word, int start, Set<String> wordSet, int[] memo) {
        if (start == word.length()) {
            return true;
        }
        if (memo[start] != 0) {
            return memo[start] == 1;
        }

        for (int end = start + 1; end <= word.length(); end++) {
            String prefix = word.substring(start, end);
            if (wordSet.contains(prefix)) {
                if (dfs(word, end, wordSet, memo)) {
                    memo[start] = 1;
                    return true;
                }
            }
        }

        memo[start] = -1;
        return false;
    }
}