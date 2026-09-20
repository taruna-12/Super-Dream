class Solution {
    public String reorganizeString(String s) {

        int[] count = new int[26];

        // Count each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Find the character with maximum frequency
        int maxChar = 0;

        for (int i = 1; i < 26; i++) {
            if (count[i] > count[maxChar]) {
                maxChar = i;
            }
        }

        // If maximum frequency is too large, impossible
        if (count[maxChar] > (s.length() + 1) / 2) {
            return "";
        }

        char[] result = new char[s.length()];

        int index = 0;

        // Place the most frequent character first
        while (count[maxChar] > 0) {
            result[index] = (char) (maxChar + 'a');
            index += 2;
            count[maxChar]--;
        }

        // Place remaining characters
        for (int i = 0; i < 26; i++) {

            while (count[i] > 0) {

                if (index >= result.length) {
                    index = 1;
                }

                result[index] = (char) (i + 'a');
                index += 2;

                count[i]--;
            }
        }

        return new String(result);
    }
}