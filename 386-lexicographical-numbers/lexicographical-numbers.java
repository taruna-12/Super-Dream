class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        int current = 1;

        for (int i = 0; i < n; i++) {
            result.add(current);

            // Try to go deeper: 1 -> 10 -> 100
            if (current * 10 <= n) {
                current = current * 10;
            }

            // Otherwise move to next number
            else {
                while (current % 10 == 9 || current + 1 > n) {
                    current = current / 10;
                }

                current++;
            }
        }

        return result;
    }
}