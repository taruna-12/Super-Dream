class Solution {
    public int hIndex(int[] citations) {

        // Sort using insertion sort
        for (int i = 1; i < citations.length; i++) {

            int key = citations[i];
            int j = i - 1;

            while (j >= 0 && citations[j] > key) {
                citations[j + 1] = citations[j];
                j--;
            }

            citations[j + 1] = key;
        }

        int n = citations.length;

        for (int i = 0; i < n; i++) {

            int papers = n - i;

            if (citations[i] >= papers) {
                return papers;
            }
        }

        return 0;
    }
}