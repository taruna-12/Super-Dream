class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int j = i;
            int lineLength = 0;

            // Find how many words can fit in this line
            while (j < words.length) {

                if (lineLength + words[j].length() + (j - i)
                        > maxWidth) {
                    break;
                }

                lineLength += words[j].length();
                j++;
            }

            int numberOfWords = j - i;
            int spaces = maxWidth - lineLength;

            StringBuilder line = new StringBuilder();

            // Last line or only one word
            if (j == words.length || numberOfWords == 1) {

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Add remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Number of gaps between words
                int gaps = numberOfWords - 1;

                int spacesPerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        // Every gap gets minimum spaces
                        for (int s = 0; s < spacesPerGap; s++) {
                            line.append(" ");
                        }

                        // Left gaps get one extra space
                        if (k - i < extraSpaces) {
                            line.append(" ");
                        }
                    }
                }
            }

            ans.add(line.toString());

            i = j;
        }

        return ans;
    }
}