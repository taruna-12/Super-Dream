class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();
    String answer = "";

    public String longestWord(String[] words) {

        // Insert all words
        for (String word : words) {
            insert(word);
        }

        // Find the longest valid word
        for (String word : words) {
            if (search(word)) {

                if (word.length() > answer.length()) {
                    answer = word;
                } 
                else if (word.length() == answer.length() 
                         && word.compareTo(answer) < 0) {
                    answer = word;
                }
            }
        }

        return answer;
    }

    public void insert(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];

            // Every prefix must be a complete word
            if (!current.isEnd) {
                return false;
            }
        }

        return true;
    }
}
