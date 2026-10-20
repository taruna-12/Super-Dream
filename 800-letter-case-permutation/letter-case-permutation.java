import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] chars, int index, List<String> result) {
        // Base case: processed all characters
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        // If it's a digit, move directly to the next index
        if (Character.isDigit(chars[index])) {
            backtrack(chars, index + 1, result);
            return;
        }

        // Branch 1: Set to lowercase and recurse
        chars[index] = Character.toLowerCase(chars[index]);
        backtrack(chars, index + 1, result);

        // Branch 2: Set to uppercase and recurse
        chars[index] = Character.toUpperCase(chars[index]);
        backtrack(chars, index + 1, result);
    }
}