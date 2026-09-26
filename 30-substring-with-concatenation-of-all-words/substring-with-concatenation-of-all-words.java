class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        HashMap<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        // Try every possible starting offset
        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int right = offset;
            int count = 0;

            HashMap<String, Integer> current = new HashMap<>();

            while (right + wordLength <= s.length()) {

                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // Word is not required
                if (!required.containsKey(word)) {

                    current.clear();
                    count = 0;
                    left = right;

                } else {

                    current.put(word,
                            current.getOrDefault(word, 0) + 1);

                    count++;

                    // Too many copies of this word
                    while (current.get(word) > required.get(word)) {

                        String leftWord =
                                s.substring(left, left + wordLength);

                        current.put(leftWord,
                                current.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }

                    // Found all words
                    if (count == wordCount) {

                        result.add(left);

                        // Move forward to search for another
                        String leftWord =
                                s.substring(left, left + wordLength);

                        current.put(leftWord,
                                current.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }
                }
            }
        }

        return result;
    }
}