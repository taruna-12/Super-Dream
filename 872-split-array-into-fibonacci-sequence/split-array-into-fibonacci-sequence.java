import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, 0, result);
        return result;
    }

    private boolean backtrack(String num, int index, List<Integer> sequence) {
        // Base case: successfully processed all characters
        if (index == num.length()) {
            return sequence.size() >= 3;
        }

        long currentNum = 0;
        for (int i = index; i < num.length(); i++) {
            // Numbers cannot have leading zeros (e.g., "03" is invalid, but "0" is fine)
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            // Incrementally build the current number to avoid repeated substring parsing
            currentNum = currentNum * 10 + (num.charAt(i) - '0');

            // Must fit within a signed 32-bit integer
            if (currentNum > Integer.MAX_VALUE) {
                break;
            }

            int size = sequence.size();

            // Check if currentNum satisfies the Fibonacci property
            if (size >= 2) {
                long expectedSum = (long) sequence.get(size - 1) + sequence.get(size - 2);
                if (currentNum < expectedSum) {
                    continue; // Keep appending digits
                } else if (currentNum > expectedSum) {
                    break; // Exceeded the required sum; further digits will only make it larger
                }
            }

            // Choose
            sequence.add((int) currentNum);

            // Explore
            if (backtrack(num, i + 1, sequence)) {
                return true;
            }

            // Backtrack
            sequence.remove(sequence.size() - 1);
        }

        return false;
    }
}