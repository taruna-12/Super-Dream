class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] result = new int[8];
        Map<String, Integer> map = new HashMap<>();

        while (n > 0) {
            String key = Arrays.toString(cells);

            if (map.containsKey(key)) {
                int cycle = map.get(key) - n;
                n = n % cycle;
            }

            map.put(key, n);

            if (n > 0) {
                n--;

                for (int i = 1; i < 7; i++) {
                    result[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
                }

                cells = result.clone();
            }
        }

        return cells;
    }
}